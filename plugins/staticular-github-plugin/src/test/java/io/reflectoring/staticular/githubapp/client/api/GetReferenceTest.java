package io.reflectoring.staticular.githubapp.client.api;

import static org.assertj.core.api.Assertions.assertThat;

import io.reflectoring.staticular.githubapp.client.ClientFactory;
import io.reflectoring.staticular.githubapp.client.api.model.InstallationToken;
import io.reflectoring.staticular.githubapp.client.api.model.Reference;

public class GetReferenceTest {

	private InstallationToken installationToken;
	private final String owner;
	private final String repo;
	private final String branch;
	private final String baseUrl;

	public GetReferenceTest(
			InstallationToken installationToken,
			String owner,
			String repo,
			String branch,
			String baseUrl) {
		this.installationToken = installationToken;
		this.owner = owner;
		this.repo = repo;
		this.branch = branch;
		this.baseUrl = baseUrl;
	}

  public void assertSuccessResponse() {
		Reference reference = client().getReference(installationToken, owner, repo, branch);
    assertThat(reference).isNotNull();
    assertThat(reference.getRef()).isNotNull();
    assertThat(reference.getObject()).isNotNull();
    assertThat(reference.getObject().getSha()).isNotNull();
  }

  GetReference client() {
    ClientFactory factory = new ClientFactory();
    return factory.createClient(GetReference.class, baseUrl);
  }

}