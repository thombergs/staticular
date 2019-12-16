package io.reflectoring.staticular.githubapp.client.api.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import io.reflectoring.staticular.githubapp.client.api.GetReferenceTest;
import io.reflectoring.staticular.githubapp.client.api.model.InstallationToken;
import io.reflectoring.staticular.githubapp.client.api.wiremock.framework.WiremockTest;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetReferenceWiremockTest extends WiremockTest {

  @BeforeEach
  void givenServerReturnsSuccess() {
    server().stubFor(get(urlEqualTo(String.format("/repos/%s/%s/git/ref/%s", owner(), repo(), branch())))
        .withHeader("Authorization", equalTo(String.format("Bearer %s", installationToken().getToken())))
        .willReturn(
            aResponse()
                .withBodyFile("response-getReference.json")
                .withStatus(200)));
  }

  @Test
  void success() {
    GetReferenceTest test = new GetReferenceTest(
        installationToken(),
        owner(),
        repo(),
        branch(),
        baseUrl());
    test.assertSuccessResponse();
  }

  private InstallationToken installationToken() {
    return new InstallationToken("blah", LocalDateTime.now());
  }

  private String baseUrl() {
    return givenBaseUrl();
  }

  private String branch() {
    return "branch";
  }

  private String repo() {
    return "repo";
  }

  private String owner() {
    return "owner";
  }

}