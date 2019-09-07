package io.reflectoring.staticular.githubapp.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.reflectoring.staticular.githubapp.client.GetInstallationToken.InstallationToken;
import org.junit.jupiter.api.Test;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.*;

class GetInstallationTokenIntegrationTest extends WiremockTest {

	@Test
	void getInstallationToken_success() {

		String installationId = givenInstallationId();
		String jwt = givenJwt();
		givenServerReturnsSuccess(installationId, jwt);

		InstallationToken installationToken = client().getInstallationToken(jwt, installationId);

		assertThat(installationToken).isNotNull();
	}

	protected String givenJwt() {
		return "4711";
	}

	protected String givenInstallationId() {
		return "0815";
	}

	private void givenServerReturnsSuccess(String installationId, String jwt) {
		server().stubFor(post(urlEqualTo(String.format("/app/installations/%s/access_tokens", installationId)))
				.withHeader("Accept", equalTo("application/vnd.github.machine-man-preview+json"))
				.withHeader("Authorization", equalTo(String.format("Bearer %s", jwt)))
				.willReturn(
						aResponse()
								.withBodyFile("response-getInstallationToken.json")
								.withStatus(201)));
	}

	private GetInstallationToken client() {
		ClientFactory factory = new ClientFactory(new ObjectMapper());
		return factory.createClient(GetInstallationToken.class, givenBaseUrl());
	}

}