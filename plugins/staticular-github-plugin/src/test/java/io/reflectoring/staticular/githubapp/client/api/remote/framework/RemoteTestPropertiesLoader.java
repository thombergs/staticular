package io.reflectoring.staticular.githubapp.client.api.remote.framework;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class RemoteTestPropertiesLoader {

  private RemoteTestPropertiesLoader() {

  }

  /**
   * Populate a {@link RemoteTestProperties} object from a properties file. The properties file
   * contains secrets so it must not be checked into source control.
   */
  static RemoteTestProperties load() {
    try {
      Properties properties = new Properties();
      properties.load(new FileReader("remote-test.properties"));
      return mapProperties(properties);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static RemoteTestProperties mapProperties(Properties properties) {
    return RemoteTestProperties.builder()
        .pathToGithubAppPrivateKeyFile(properties.getProperty("pathToGitHubAppPrivateKeyFile"))
        .githubAppId(properties.getProperty("githubAppId"))
        .githubInstallationId(properties.getProperty("githubInstallationId"))
        .owner(properties.getProperty("owner"))
        .repo(properties.getProperty("repo"))
        .branchName(properties.getProperty("branchName"))
        .build();
  }

}
