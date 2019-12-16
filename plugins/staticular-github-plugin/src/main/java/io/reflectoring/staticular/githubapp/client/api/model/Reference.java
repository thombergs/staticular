package io.reflectoring.staticular.githubapp.client.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Reference {

  private String ref;
  private String nodeId;
  private String url;
  private Commit object;

  public Reference(
      @JsonProperty("ref") String ref,
      @JsonProperty("node_id") String nodeId,
      @JsonProperty("url") String url,
      @JsonProperty("object") Commit object) {
    this.ref = ref;
    this.nodeId = nodeId;
    this.url = url;
    this.object = object;
  }

}
