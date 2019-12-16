package io.reflectoring.staticular.githubapp.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.reflectoring.staticular.githubapp.client.api.model.InstallationToken;
import io.reflectoring.staticular.githubapp.client.api.model.Tree;
import io.reflectoring.staticular.githubapp.client.api.model.TreeSha;
import java.util.List;
import lombok.Value;

public interface CreateTree {

  /**
   * Creates a tree in a GitHub repo.
   *
   * @see <a href="https://developer.github.com/v3/git/trees/#create-a-tree">Github API</a>
   */
  @Headers({
      "Content-Type: application/json",
      "Authorization: Bearer {token}"
  })
  @RequestLine("POST /repos/{owner}/{repo}/git/trees")
  TreeSha createTree(
      CreateTreeRequest body,
      @Param("token") InstallationToken token,
      @Param("owner") String owner,
      @Param("repo") String repo);

  @Value
  class CreateTreeRequest {

    private final List<Tree> tree;
    private final TreeSha base_tree;
  }

}
