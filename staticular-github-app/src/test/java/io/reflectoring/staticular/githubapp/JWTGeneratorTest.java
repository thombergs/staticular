package io.reflectoring.staticular.githubapp;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import static io.reflectoring.staticular.githubapp.RSAKeyTestData.*;
import static org.assertj.core.api.Assertions.*;

class JWTGeneratorTest {

	@Test
	void generateJsonWebToken_success() {
		JWTGenerator generator = new JWTGenerator();
		String jwt = generator.generateJWT(validRSAPrivateKey(), githubAppId());

		Jwt parsedJwt = Jwts.parser()
				.setSigningKey(validRSAPublicKey())
				.parse(jwt);

		assertThat(parsedJwt).isNotNull();
	}

	private String githubAppId() {
		return "12345";
	}

}