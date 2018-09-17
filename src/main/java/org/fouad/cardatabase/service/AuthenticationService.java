package org.fouad.cardatabase.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationService {
	static final long EXPIRATIONTIME = 1; // 1 day
	static final String SIGNINGKEY = "SecretKey";
	static final String PREFIX = "Bearer";

	// Add token to Authorization header
	public static void addToken(HttpServletResponse response, String userName) {
		Date expiration = getTokenExpirationTime(EXPIRATIONTIME);
		String token = createToken(userName, expiration);
		response.addHeader("Authorization", PREFIX.concat(token));
		response.addHeader("Access-Control-Expose-Headers", "Authorization");
	}

	// Get token from Authorization header
	public static Authentication getAuthentication(HttpServletRequest request) {
		Authentication authentication = null;
		String token = request.getHeader("Authorization");
		if (token != null) {
			String user = getSubjectFromToken(token);
			authentication = new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
		}
		return authentication;
	}

	private static String createToken(String userName, Date expiration) {
		String token = Jwts.builder()//
				.setSubject(userName)//
				.setExpiration(expiration)//
				.signWith(SignatureAlgorithm.HS512, SIGNINGKEY)//
				.compact();
		return token;
	}

	private static String getSubjectFromToken(String token) {
		String subject = Jwts.parser()//
				.setSigningKey(SIGNINGKEY)//
				.parseClaimsJws(token.replaceFirst(PREFIX, ""))//
				.getBody()//
				.getSubject();
		return subject;
	}

	private static Date getTokenExpirationTime(long expirationTime) {
		Date expiration = Date.from(
				LocalDateTime.now().plusDays(expirationTime).toInstant(ZoneOffset.of(ZoneId.systemDefault().getId())));
		return expiration;
	}
}