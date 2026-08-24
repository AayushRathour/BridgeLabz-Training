package com.aayush.fundoo.cache;

import java.time.Duration;
import java.util.Optional;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
// Wraps Redis for two jobs on the authorization path:
//  1. Caching a token's already-verified email, so repeat requests with the
//     same token skip JWT signature parsing entirely (performance).
//  2. Blacklisting a token on logout, so a JWT can be rejected before its
//     natural expiry even though JWTs are normally stateless (correctness).
public class TokenCacheService {

	private static final String TOKEN_CACHE_PREFIX = "auth:token:";
	private static final String BLACKLIST_PREFIX = "auth:blacklist:";

	// How long a validated token stays cached before the filter re-verifies it from scratch.
	private static final Duration CACHE_TTL = Duration.ofMinutes(5);

	private final StringRedisTemplate redisTemplate;

	public TokenCacheService(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	// Remembers that this exact token belongs to this email, for CACHE_TTL.
	public void cacheEmailForToken(String token, String email) {
		redisTemplate.opsForValue().set(TOKEN_CACHE_PREFIX + token, email, CACHE_TTL);
	}

	// Returns the cached email for a token, if we've already verified it recently.
	public Optional<String> getCachedEmail(String token) {
		return Optional.ofNullable(redisTemplate.opsForValue().get(TOKEN_CACHE_PREFIX + token));
	}

	// Marks a token as logged-out. ttlMillis should be however long the token
	// would otherwise remain valid, so the blacklist entry disappears exactly
	// when the JWT itself would have expired anyway (no need to keep it forever).
	public void blacklistToken(String token, long ttlMillis) {
		redisTemplate.delete(TOKEN_CACHE_PREFIX + token); // stop trusting any cached "valid" entry immediately
		redisTemplate.opsForValue().set(BLACKLIST_PREFIX + token, "true", Duration.ofMillis(Math.max(ttlMillis, 1000)));
	}

	// Checked by the filter before anything else - a blacklisted token is rejected outright.
	public boolean isBlacklisted(String token) {
		return Boolean.TRUE.equals(redisTemplate.hasKey(BLACKLIST_PREFIX + token));
	}
}
