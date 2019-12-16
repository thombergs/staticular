package io.reflectoring.staticular.githubapp.client;

import io.reflectoring.staticular.githubapp.client.api.model.GithubJwt;
import java.security.Key;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import io.jsonwebtoken.Jwts;

public class JWTGenerator {

	/**
	 * Creates a JWT for communicating with GitHub. The JWT is used only to get an
	 * installation token from GitHub which in turn is used to interact with GitHub
	 * in the name of a GitHub App.
	 * @param githubAppPrivateKey the private key of the GitHub installation.
	 * @param githubAppId ID of the GitHub application.
	 * @return
	 */
	public GithubJwt generateJWT(Key githubAppPrivateKey, String githubAppId) {
		return new GithubJwt(Jwts.builder()
				.setIssuer(githubAppId)
				.setIssuedAt(now())
				.setExpiration(tenMinutesFromNow())
				.signWith(githubAppPrivateKey)
				.compact());
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
