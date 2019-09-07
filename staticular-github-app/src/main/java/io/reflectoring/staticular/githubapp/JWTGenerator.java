package io.reflectoring.staticular.githubapp;

import java.security.Key;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import io.jsonwebtoken.Jwts;

public class JWTGenerator {

	public String generateJWT(Key githubAppPrivateKey, String githubAppId) {
		return Jwts.builder()
				.setIssuer(githubAppId)
				.setIssuedAt(now())
				.setExpiration(tenMinutesFromNow())
				.signWith(githubAppPrivateKey)
				.compact();
	}

	private Date tenMinutesFromNow() {
		// 10 minutes is the maximum expiration time allowed by GitHub.
		// We set expiry to 5 minutes anyway to avoid problems with clock deviation between
		// the server and us.
		return new Date(now().getTime() + (1000 * 60 * 5));
	}

	private Date now() {
		ZonedDateTime nowInDefaultTimezone = ZonedDateTime.now();
		ZonedDateTime nowInUTC = nowInDefaultTimezone.withZoneSameInstant(ZoneOffset.UTC);
		return Date.from(nowInUTC.toInstant());
	}

}
