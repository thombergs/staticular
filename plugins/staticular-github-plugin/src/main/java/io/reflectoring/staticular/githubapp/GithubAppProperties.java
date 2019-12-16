package io.reflectoring.staticular.githubapp;

import io.reflectoring.staticular.githubapp.client.PemKeyReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PrivateKey;

import io.reflectoring.staticular.processor.common.ConfigurationException;
import lombok.Builder;
import lombok.Getter;

/**
 * Configuration properties for the Github App that is responsible for interacting with Github on behalf of staticular.
 */
@Builder
class GithubAppProperties {

	/**
	 * Path to the .pem file containing the private key of the Staticular Github App.
	 */
	private final Path pathToGithubAppPrivateKey;

	/**
	 * ID of the Github App, as issued by Github.
	 */
	@Getter
	private final String githubAppId;

	public GithubAppProperties(
			Path pathToGithubAppPrivateKey,
			String githubAppId) {
		this.pathToGithubAppPrivateKey = pathToGithubAppPrivateKey;
		this.githubAppId = githubAppId;
	}

	PrivateKey getGitHubAppPrivateKey() {
		try {
			String keyString = Files.readString(this.pathToGithubAppPrivateKey);
			return PemKeyReader.fromString(keyString).getPrivate();
		} catch (Exception e) {
			throw new ConfigurationException("pathToGithubAppPrivateKey", this.pathToGithubAppPrivateKey);
		}
	}


}
