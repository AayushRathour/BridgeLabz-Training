package com.aayush.authservice.cache;

import java.time.Duration;
import java.util.Optional;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TokenCacheService {

    private static final String TOKEN_CACHE_PREFIX = "auth:token:";
    private static final String BLACKLIST_PREFIX = "auth:blacklist:";

    // Maximum amount of time a validated token is kept in Redis.
    private static final Duration CACHE_TTL = Duration.ofMinutes(5);

    private final StringRedisTemplate redisTemplate;

    public TokenCacheService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * Cache the verified email against the JWT.
     *
     * The expiry time of the JWT is also stored.
     * This prevents Redis from trusting a token after the JWT itself expires.
     */
    public void cacheEmailForToken(
            String token,
            String email,
            long jwtExpirationTimeMillis) {

        long now = System.currentTimeMillis();

        // Don't cache an already-expired token.
        if (jwtExpirationTimeMillis <= now) {
            return;
        }

        long remainingJwtTime = jwtExpirationTimeMillis - now;

        // Cache cannot live longer than the JWT itself.
        long cacheTime = Math.min(
                CACHE_TTL.toMillis(),
                remainingJwtTime
        );

        String value = email + "|" + jwtExpirationTimeMillis;

        redisTemplate.opsForValue().set(
                TOKEN_CACHE_PREFIX + token,
                value,
                Duration.ofMillis(cacheTime)
        );
    }

    /**
     * Returns the cached email only when the JWT has not expired.
     */
    public Optional<String> getCachedEmail(String token) {

        String value = redisTemplate.opsForValue()
                .get(TOKEN_CACHE_PREFIX + token);

        if (value == null) {
            return Optional.empty();
        }

        String[] parts = value.split("\\|", 2);

        if (parts.length != 2) {
            // Corrupted/old cache entry.
            redisTemplate.delete(TOKEN_CACHE_PREFIX + token);
            return Optional.empty();
        }

        String email = parts[0];

        long expirationTime;

        try {
            expirationTime = Long.parseLong(parts[1]);
        } catch (NumberFormatException exception) {
            redisTemplate.delete(TOKEN_CACHE_PREFIX + token);
            return Optional.empty();
        }

        // Never authenticate an expired JWT from cache.
        if (expirationTime <= System.currentTimeMillis()) {
            redisTemplate.delete(TOKEN_CACHE_PREFIX + token);
            return Optional.empty();
        }

        return Optional.of(email);
    }

    /**
     * Blacklist a JWT during logout.
     *
     * The blacklist remains only until the JWT would naturally expire.
     */
    public void blacklistToken(
            String token,
            long ttlMillis) {

        // Immediately remove cached authentication information.
        redisTemplate.delete(TOKEN_CACHE_PREFIX + token);

        // Never keep a blacklist entry forever.
        long safeTtl = Math.max(ttlMillis, 1000);

        redisTemplate.opsForValue().set(
                BLACKLIST_PREFIX + token,
                "true",
                Duration.ofMillis(safeTtl)
        );
    }

    /**
     * Check whether the JWT has been blacklisted.
     */
    public boolean isBlacklisted(String token) {

        return Boolean.TRUE.equals(
                redisTemplate.hasKey(BLACKLIST_PREFIX + token)
        );
    }

    /**
     * Remove a token from Redis completely.
     *
     * Useful for testing/admin purposes.
     */
    public void removeToken(String token) {

        redisTemplate.delete(TOKEN_CACHE_PREFIX + token);
        redisTemplate.delete(BLACKLIST_PREFIX + token);
    }
}