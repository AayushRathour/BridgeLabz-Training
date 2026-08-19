package com.aayush.fundoo.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	// TAkes the values from Apllication.properties for token abd expire time 
	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.expiration}")
	private long expiration;
	
	//JWT token created here and imp .compact() it produces the final JWT string.
	public String generateToken(String email) {
		// Converts the secret into UTF-8 bytes and creates a secure HMAC SecretKey for signing the JWT.
		SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)); //UTF-8 is way of converting text/characters into bytes
		return Jwts.builder()
				.subject(email)//payLoad
				.issuedAt(new Date())//PayLoad
				.expiration(new Date(System.currentTimeMillis()+ expiration))//PayLoad
				.signWith(key) //Header & Signature
				.compact();
	}
	
	// Extracts the email from the JWT
	public String  extractEmail(String token) {
		SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
		
		return Jwts.parser()
				.verifyWith(key) // verify the token
				.build()
				.parseSignedClaims(token) // Reads and verifies the JWT
				.getPayload()
				.getSubject();// Gets the subject, which contains the email
		
		
	}
	 // Checks whether the JWT is valid or not 
	public boolean isTokenValid(String token) {
		
		try {
			extractEmail(token);
			return true;
		}catch (Exception e) {
			return false;
			
		}
		
	}
	

}
