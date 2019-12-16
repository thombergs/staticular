package io.reflectoring.staticular.githubapp.client.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.reflectoring.staticular.githubapp.client.api.model.InstallationToken;
import lombok.Value;

public interface CreatePullRequest {

  /**
   * Creates a new pullrequest.
   * @see <a href="https://developer.github.com/v3/pulls/#create-a-pull-request">GitHub API</a>
   */
  @Headers({
      "Content-Type: application/json",
      "Authorization: Bearer {token}"
  })
  @RequestLine("POST /repos/{owner}/{repo}/pulls")
  void createPullRequest(
      CreatePullrequestRequest body,
      @Param("token") InstallationToken token,
      @Param("owner") String owner,
      @Param("repo") String repo);

  @Value
  class CreatePullrequestRequest {
    private final String title;
    private final String head;
    private final String base;
    private final String body;
    @JsonProperty("maintainer_can_modify")
    private final boolean maintainerCanModify = true;

    public CreatePullrequestRequest(
        String title,
        String head,
        String base,
        String body) {
      this.title = title;
      this.head = head;
      this.base = base;
      this.body = body;
    }
  }

  // https://developer.github.com/v3/git/#introducing-the-git-database-api
  // 0. get most current commit on target branch
  // 1. post a new blob object to GitHub
  // 2. post a new tree object with the file path pointing to the blob just created
  // 3. post a new commit object pointing to the tree just created
  // 4. post a new reference (branch) pointing to the commit just created
  // 5. create a pull request from the branch just created to the configured target branch

}
