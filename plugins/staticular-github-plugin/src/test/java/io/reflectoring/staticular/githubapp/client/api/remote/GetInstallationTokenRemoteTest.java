package io.reflectoring.staticular.githubapp.client.api.remote;

import io.reflectoring.staticular.githubapp.client.JWTGenerator;
import io.reflectoring.staticular.githubapp.client.PemKeyReader;
import io.reflectoring.staticular.githubapp.client.api.GetInstallationTokenTest;
import io.reflectoring.staticular.githubapp.client.api.model.GithubJwt;
import io.reflectoring.staticular.githubapp.client.api.remote.framework.RemoteTest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PrivateKey;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("remote")
class GetInstallationTokenRemoteTest extends RemoteTest {

  @Test
  void success() {
    GetInstallationTokenTest test = new GetInstallationTokenTest(
        jwt(),
        properties().getGithubInstallationId(),
        properties().getGithubUrl());
    test.assertSuccessResponse();
  }

  private GithubJwt jwt() {
    JWTGenerator jwtGenerator = new JWTGenerator();
    return jwtGenerator.generateJWT(getGithubAppKey(), properties().getGithubAppId());
  }

  private PrivateKey getGithubAppKey() {
    try {

      String keyString = Files.readString(Path.of(properties().getPathToGithubAppPrivateKeyFile()));

      return PemKeyReader.fromString(keyString).getPrivate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
