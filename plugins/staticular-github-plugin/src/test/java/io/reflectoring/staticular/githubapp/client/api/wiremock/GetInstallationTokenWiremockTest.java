package io.reflectoring.staticular.githubapp.client.api.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import io.reflectoring.staticular.githubapp.client.api.GetInstallationTokenTest;
import io.reflectoring.staticular.githubapp.client.api.model.GithubJwt;
import io.reflectoring.staticular.githubapp.client.api.wiremock.framework.WiremockTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetInstallationTokenWiremockTest extends WiremockTest {

  @BeforeEach
  void givenServerReturnsSuccess() {
    server().stubFor(post(urlEqualTo(String.format("/app/installations/%s/access_tokens", installationId())))
        .withHeader("Accept", equalTo("application/vnd.github.machine-man-preview+json"))
        .withHeader("Authorization", equalTo(String.format("Bearer %s", jwt().getValue())))
        .willReturn(
            aResponse()
                .withBodyFile("response-getInstallationToken.json")
                .withStatus(201)));
  }

  @Test
  void success() {
    GetInstallationTokenTest test = new GetInstallationTokenTest(
        jwt(),
        installationId(),
        givenBaseUrl());
    test.assertSuccessResponse();
  }

  private GithubJwt jwt() {
    return new GithubJwt("4711");
  }

  private String installationId() {
    return "0815";
  }

}