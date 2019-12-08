package io.reflectoring.staticular.githubapp.client;

import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PrivateKey;

import io.reflectoring.staticular.githubapp.JWTGenerator;
import io.reflectoring.staticular.githubapp.PemKeyReader;
import org.junit.jupiter.api.Tag;
import static org.assertj.core.api.Assertions.*;

@Tag("remote")
class GetInstallationTokenRemoteTest extends GetInstallationTokenIntegrationTest {

	@Override
	protected String givenInstallationId() {
		return "1771160";
	}

	@Override
	protected String givenJwt() {
		JWTGenerator jwtGenerator = new JWTGenerator();
		return jwtGenerator.generateJWT(getGithubAppKey(), getGithubAppId());
	}

	private PrivateKey getGithubAppKey() {
		try {
			String keyPath = System.getProperty("STATICULAR_GITHUB_APP_PRIVATE_KEY_FILE");

			assertThat(keyPath)
					.withFailMessage("System property 'STATICULAR_GITHUB_APP_PRIVATE_KEY_FILE' must contain the path to the github app private key file (.pem)!")
					.isNotNull();

			String keyString = Files.readString(Path.of(keyPath));

			return PemKeyReader.fromString(keyString).getPrivate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String getGithubAppId() {
		String githubAppId = System.getProperty("STATICULAR_GITHUB_APP_ID");

		assertThat(githubAppId)
				.withFailMessage("System property 'STATICULAR_GITHUB_APP_ID' must contain the github app id!")
				.isNotNull();

		return githubAppId;
	}

	@Override
	String givenBaseUrl() {
		return "https://api.github.com";
	}
}
