package io.reflectoring.staticular.githubapp.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.reflectoring.staticular.githubapp.client.api.model.InstallationToken;
import java.util.Base64;
import lombok.Value;

public interface CreateFile {

  @Headers({
      "Content-Type: application/json",
      "Authorization: Bearer {token}"
  })
  @RequestLine("PUT /repos/{owner}/{repo}/contents/{filename}")
  void createFile(
      CreateFileRequest body,
      @Param("token") InstallationToken token,
      @Param("owner") String owner,
      @Param("repo") String repo,
      @Param("filename") String filename);

  @Value
  class CreateFileRequest {

    private final String commitMessage;
    private final Committer committer;
    private final String content;

    public CreateFileRequest(
        String commitMessage,
        Committer committer,
        String content) {
      this.commitMessage = commitMessage;
      this.committer = committer;
      this.content = Base64.getEncoder().encodeToString(content.getBytes());
    }
  }

  @Value
  class Committer {

    private String name;
    private String email;
  }
}
