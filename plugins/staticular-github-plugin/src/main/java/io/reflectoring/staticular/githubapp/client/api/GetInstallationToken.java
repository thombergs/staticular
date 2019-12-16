package io.reflectoring.staticular.githubapp.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.reflectoring.staticular.githubapp.client.api.model.GithubJwt;
import io.reflectoring.staticular.githubapp.client.api.model.InstallationToken;

public interface GetInstallationToken {

  /**
   * Creates an {@link InstallationToken} that can be used to interact with a GitHub repository in the name of a GitHub
   * app.
   *
   * @param jwt            the JWT with the secret key of the app.
   * @param installationId the ID of the app installation for which the token shall be created.
   */
  @Headers({
      "Accept: application/vnd.github.machine-man-preview+json",
      "Authorization: Bearer {jwt}"
  })
  @RequestLine("POST /app/installations/{installationId}/access_tokens")
  InstallationToken getInstallationToken(
      @Param("jwt") GithubJwt jwt,
      @Param("installationId") String installationId);

}
