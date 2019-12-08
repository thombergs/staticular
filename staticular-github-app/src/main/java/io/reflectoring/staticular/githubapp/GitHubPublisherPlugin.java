package io.reflectoring.staticular.githubapp;

import io.reflectoring.staticular.spi.PluginId;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import io.reflectoring.staticular.spi.ContentPublisherPlugin;
import io.reflectoring.staticular.spi.model.StaticFile;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GitHubPublisherPlugin implements ContentPublisherPlugin {

	private final GithubAppProperties githubAppProperties;
	private final JWTGenerator jwtGenerator;

	@Override
	public PluginId id() {
		return new PluginId("github");
	}

	@Override
	public void publishContent(StaticFile staticFile) {
		try {

			HttpRequest request = HttpRequest.newBuilder()
					.PUT(BodyPublishers.ofString("{\n" +
							"  \"message\": \"my commit message\",\n" +
							"  \"committer\": {\n" +
							"    \"name\": \"Monalisa Octocat\",\n" +
							"    \"email\": \"octocat@github.com\"\n" +
							"  },\n" +
							"  \"content\": \"bXkgbmV3IGZpbGUgY29udGVudHM=\"\n" +
							"}"))
					.header("Authorization", generateJsonWebToken())
					.uri(URI.create("https://api.github.com/repos/thombergs/staticman-test/contents/comments/comment.yml"))
					.build();

			HttpClient client = HttpClient.newBuilder().build();

			client.send(request, BodyHandlers.ofString());

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private String generateJsonWebToken() {
		return jwtGenerator.generateJWT(githubAppProperties.getGitHubAppPrivateKey(), githubAppProperties.getGithubAppId());
	}

}
