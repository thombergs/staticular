package io.reflectoring.staticular.githubapp.client.api.model;

import lombok.Value;

@Value
public class Tree {
  private final String path;
  private final String mode = "100644";
  private final String type = "blob";
  private final String content;

  public Tree(String path, String content) {
    this.path = path;
    this.content = content;
  }
}
