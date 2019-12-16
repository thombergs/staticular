package io.reflectoring.staticular.githubapp.client.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class BlobSha {

  private final String sha;

  @JsonCreator
  public BlobSha(@JsonProperty("sha") String sha) {
    this.sha = sha;
  }
}
