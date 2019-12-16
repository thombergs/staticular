package io.reflectoring.staticular.githubapp.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.reflectoring.staticular.githubapp.client.api.model.CommitSha;
import io.reflectoring.staticular.githubapp.client.api.model.InstallationToken;
import io.reflectoring.staticular.githubapp.client.api.model.TreeSha;
import lombok.Value;

public interface CreateReference {

  /**
   * Creates a reference (i.e. a branch) in a GitHub repo.
   *
   * @see <a href="https://developer.github.com/v3/git/refs/#create-a-reference">Github API</a>
   */
  @Headers({
      "Content-Type: application/json",
      "Authorization: Bearer {token}"
  })
  @RequestLine("POST /repos/{owner}/{repo}/git/refs")
  TreeSha createReference(
      CreateReferenceRequest body,
      @Param("token") InstallationToken token,
      @Param("owner") String owner,
      @Param("repo") String repo);

  @Value
  class CreateReferenceRequest {

    private final String ref;
    private final CommitSha sha;

  }
}
