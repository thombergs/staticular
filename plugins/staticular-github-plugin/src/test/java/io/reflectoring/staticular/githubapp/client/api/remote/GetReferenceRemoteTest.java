package io.reflectoring.staticular.githubapp.client.api.remote;

import io.reflectoring.staticular.githubapp.client.GithubService;
import io.reflectoring.staticular.githubapp.client.api.GetReferenceTest;
import io.reflectoring.staticular.githubapp.client.api.model.InstallationToken;
import io.reflectoring.staticular.githubapp.client.api.remote.framework.RemoteTest;
import java.nio.file.Path;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("remote")
class GetReferenceRemoteTest extends RemoteTest {

  @Test
  void success() {
    GetReferenceTest test = new GetReferenceTest(
        givenInstallationToken(),
        properties().getOwner(),
        properties().getRepo(),
        properties().getBranchName(),
        properties().getGithubUrl());
    test.assertSuccessResponse();
  }

  protected InstallationToken givenInstallationToken() {
    return new GithubService().login(
        Path.of(properties().getPathToGithubAppPrivateKeyFile()),
        properties().getGithubAppId(),
        properties().getGithubInstallationId());
  }

}