package io.reflectoring.staticular.githubapp.client.api.remote.framework;

import lombok.Builder;
import lombok.Value;

/**
 * This class contains all properties that are needed to execute the GitHub client tests
 * against a the real GitHub API. In order for the tests to run successfully, all properties
 * must be set to valid values.
 */
@Value
@Builder
public class RemoteTestProperties {

  private final String githubUrl = "https://api.github.com";

  /**
   * The path to the .pem file containing the private key of the GitHub app. You can create
   * an app in GitHub under "Settings -> Developer settings" and let GitHub create the private
   * key for you.
   */
  private final String pathToGithubAppPrivateKeyFile;

  /**
   * The ID of the GitHub App. Can be looked up in GitHub under "Settings -> Developer settings -> Edit App".
   * At the time of writing a GitHub App is a 5-digit number.
   */
  private final String githubAppId;

  /**
   * The ID of the installation of the GitHub App. The app can be installed to a GitHub repository
   * under "Settings -> Developer Settings -> GitHub Apps -> Install App". The installation ID can
   * then be read from the URL under "Settings -> Applications -> Configure". The URL should read
   * like "https://github.com/settings/installations/<INSTALLATION_ID>".
   */
  private final String githubInstallationId;

  /**
   * The name of the branch to use for tests.
   */
  private final String branchName;

  /**
   * The name of the owner of the test repository on GitHub.
   */
  private final String owner;

  /**
   * The name of the test repository on GitHub.
   */
  private final String repo;

}
