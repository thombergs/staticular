package io.reflectoring.staticular.githubapp.client.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public
class InstallationToken {

  private final String token;
  private final LocalDateTime expires_at;

  @JsonCreator
  public InstallationToken(
      @JsonProperty("token") String token,
      @JsonProperty("expires_at") LocalDateTime expires_at) {
    this.token = token;
    this.expires_at = expires_at;
  }

  @Override
  public String toString(){
    return this.token;
  }
}
