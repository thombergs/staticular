package io.reflectoring.staticular.githubapp.client.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Commit {

  private final CommitSha sha;
  private final String url;

  @JsonCreator
  public Commit(
      @JsonProperty("sha") String sha,
      @JsonProperty("url") String url) {
    this.sha = new CommitSha(sha);
    this.url = url;
  }
}
