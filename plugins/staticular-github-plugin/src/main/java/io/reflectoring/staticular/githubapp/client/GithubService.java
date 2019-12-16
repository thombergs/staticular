package io.reflectoring.staticular.githubapp.client;

import io.reflectoring.staticular.githubapp.client.api.GetInstallationToken;
import io.reflectoring.staticular.githubapp.client.api.model.GithubJwt;
import io.reflectoring.staticular.githubapp.client.api.model.InstallationToken;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PrivateKey;

public class GithubService {

  private static final String GITHUB_API_URL = "https://api.github.com";

  private final GetInstallationToken getInstallationTokenClient;
  private final JWTGenerator jwtGenerator = new JWTGenerator();

  public GithubService() {
    this.getInstallationTokenClient = new ClientFactory().createClient(GetInstallationToken.class, GITHUB_API_URL);
  }

  /**
   * "Logs in" to the GitHub API by requesting an {@link InstallationToken}.
   *
   * @param privateAppKey  the private key of the GitHub app.
   * @param appId          the ID of the GitHub app.
   * @param installationId the ID of the installation of the GitHub App (installation to a specific repository).
   * @return an {@link InstallationToken} to use in further API requests.
   */
  public InstallationToken login(PrivateKey privateAppKey, String appId, String installationId) {
    GithubJwt jwt = jwtGenerator.generateJWT(privateAppKey, appId);
    return getInstallationTokenClient.getInstallationToken(jwt, installationId);
  }

  /**
   * "Logs in" to the GitHub API by requesting an {@link InstallationToken}.
   *
   * @param pathToPrivateAppKey the path to the file containing the private key of the GitHub app.
   * @param appId               the ID of the GitHub app.
   * @param installationId      the ID of the installation of the GitHub App (installation to a specific repository).
   * @return an {@link InstallationToken} to use in further API requests.
   */
  public InstallationToken login(Path pathToPrivateAppKey, String appId, String installationId) {
    try {
      String keyString = Files.readString(pathToPrivateAppKey);
      return login(PemKeyReader.fromString(keyString).getPrivate(),
          appId,
          installationId);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
