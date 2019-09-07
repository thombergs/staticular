package io.reflectoring.staticular.githubapp;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import io.reflectoring.staticular.processor.ContentPublisher;
import io.reflectoring.staticular.processor.StaticFile;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GitHubPublisher implements ContentPublisher {

	private final GithubAppProperties githubAppProperties;
	private final JWTGenerator jwtGenerator;

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
