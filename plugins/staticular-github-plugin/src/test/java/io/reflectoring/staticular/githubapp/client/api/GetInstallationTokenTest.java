package io.reflectoring.staticular.githubapp.client.api;

import static org.assertj.core.api.Assertions.assertThat;

import io.reflectoring.staticular.githubapp.client.ClientFactory;
import io.reflectoring.staticular.githubapp.client.api.model.GithubJwt;
import io.reflectoring.staticular.githubapp.client.api.model.InstallationToken;

public class GetInstallationTokenTest {

  private final GithubJwt jwt;
  private final String installationId;
  private String baseUrl;

  public GetInstallationTokenTest(GithubJwt jwt, String installationId, String baseUrl) {
    this.jwt = jwt;
    this.installationId = installationId;
    this.baseUrl = baseUrl;
  }

  public void assertSuccessResponse() {
    InstallationToken installationToken = client().getInstallationToken(jwt, installationId);

    assertThat(installationToken).isNotNull();
    assertThat(installationToken.getToken()).isNotNull();
  }

  private GetInstallationToken client() {
    ClientFactory factory = new ClientFactory();
    return factory.createClient(GetInstallationToken.class, baseUrl);
  }

}