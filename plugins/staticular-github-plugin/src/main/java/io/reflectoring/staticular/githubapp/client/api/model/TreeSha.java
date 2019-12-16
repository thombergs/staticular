package io.reflectoring.staticular.githubapp.client.api.model;

import lombok.Value;

@Value
public class TreeSha {

  private String value;

  @Override
  public String toString() {
    return this.value;
  }
}
