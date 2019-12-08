package io.reflectoring.staticular.githubapp;

import java.nio.file.Path;
import java.security.PrivateKey;

import io.reflectoring.staticular.processor.common.ConfigurationException;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class GithubAppPropertiesTest {

	@Test
	void configurePathToGitHubAppPrivateKey_success() {
		GithubAppProperties githubAppProperties = GithubAppProperties.builder()
				.pathToGithubAppPrivateKey(Path.of("src/test/resources/test-private-key.pem"))
				.build();

		PrivateKey key = githubAppProperties.getGitHubAppPrivateKey();
		assertThat(key).isNotNull();
	}

	@Test
	void configurePathToGitHubAppPrivateKey_fail() {
		GithubAppProperties githubAppProperties = GithubAppProperties.builder()
				.pathToGithubAppPrivateKey(Path.of("does/not/exist.pem"))
				.build();

		assertThatThrownBy(githubAppProperties::getGitHubAppPrivateKey)
				.isInstanceOf(ConfigurationException.class)
				.hasMessageContaining("pathToGithubAppPrivateKey");

	}

}