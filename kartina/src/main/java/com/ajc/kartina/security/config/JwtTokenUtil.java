package com.ajc.kartina.security.config;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ajc.kartina.security.model.UserPrinciple;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenUtil {
	private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

	@Value("${kartina.jwtSecret}")
	private String jwtSecret;

	@Value("${kartina.jwtExpiration}")
	private int jwtExpiration;

	public String generateJwtToken(Authentication authentication) {
		UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
		return Jwts	.builder()
					.setSubject(userPrinciple.getEmail())
					.setIssuedAt(new Date())
					.setExpiration(new Date((new Date()).getTime() + jwtExpiration * 1000))
					.signWith(SignatureAlgorithm.HS512, jwtSecret)
					.compact();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(authToken);
			return true;
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token -> Message: {}", e);
		} catch (ExpiredJwtException e) {
			logger.error("Expired JWT token -> Message: {}", e);
		} catch (UnsupportedJwtException e) {
			logger.error("Unsupported JWT token -> Message: {}", e);
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty -> Message: {}", e);
		}
		return false;
	}

	public String getUsernameFromJwtToken(String token) {
		return Jwts	.parser()
					.setSigningKey(jwtSecret)
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
	}

}
