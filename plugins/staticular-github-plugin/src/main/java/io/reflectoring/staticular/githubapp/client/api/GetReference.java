package io.reflectoring.staticular.githubapp.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.reflectoring.staticular.githubapp.client.api.model.InstallationToken;
import io.reflectoring.staticular.githubapp.client.api.model.Reference;

public interface GetReference {

  /**
   * Gets a reference (i.e. a branch) from GitHub.
   *
   * @see <a href="https://developer.github.com/v3/git/refs/#get-a-single-reference">Github API</a>
   */
  @Headers({
      "Content-Type: application/json",
      "Authorization: Bearer {token}"
  })
  @RequestLine("GET /repos/{owner}/{repo}/git/ref/{ref}")
  Reference getReference(
      @Param("token") InstallationToken token,
      @Param("owner") String owner,
      @Param("repo") String repo,
      @Param("ref") String ref);

}
