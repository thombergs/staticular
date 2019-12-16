package io.reflectoring.staticular.githubapp.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.reflectoring.staticular.githubapp.client.api.model.BlobSha;
import io.reflectoring.staticular.githubapp.client.api.model.InstallationToken;
import lombok.Getter;

public interface CreateBlob {

  /**
   * Creates a blob in a GitHub repo.
   * @see <a href="https://developer.github.com/v3/git/blobs/#create-a-blob">Github API</a>
   */
  @Headers({
      "Content-Type: application/json",
      "Authorization: Bearer {token}"
  })
  @RequestLine("POST /repos/{owner}/{repo}/git/blobs")
  BlobSha createBlob(
      CreateBlobRequest body,
      @Param("token") InstallationToken token,
      @Param("owner") String owner,
      @Param("repo") String repo);

  @Getter
  class CreateBlobRequest {

    private final String base64Content;
    private final String encoding = "base64";

    public CreateBlobRequest(String base64Content) {
      this.base64Content = base64Content;
    }
  }

}
