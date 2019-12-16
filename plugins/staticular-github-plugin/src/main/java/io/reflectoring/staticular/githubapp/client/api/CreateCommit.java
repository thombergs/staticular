package io.reflectoring.staticular.githubapp.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.reflectoring.staticular.githubapp.client.api.model.CommitSha;
import io.reflectoring.staticular.githubapp.client.api.model.InstallationToken;
import io.reflectoring.staticular.githubapp.client.api.model.Tree;
import io.reflectoring.staticular.githubapp.client.api.model.TreeSha;
import java.time.LocalDate;
import java.util.List;
import lombok.Value;

public interface CreateCommit {

  /**
   * Creates a commit in a GitHub repo.
   *
   * @see <a href="https://developer.github.com/v3/git/commits/#create-a-commit">Github API</a>
   */
  @Headers({
      "Content-Type: application/json",
      "Authorization: Bearer {token}"
  })
  @RequestLine("POST /repos/{owner}/{repo}/git/commits")
  TreeSha createCommit(
      CreateCommitRequest body,
      @Param("token") InstallationToken token,
      @Param("owner") String owner,
      @Param("repo") String repo);

  @Value
  class CreateCommitRequest {

    private final String message;
    private final TreeSha tree;
    private final List<CommitSha> parents;
    private final Author author;
    private final Author committer;

  }

  @Value
  class Author {
    private final String name;
    private final String email;
    private final LocalDate date;
  }

}
