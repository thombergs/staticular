package io.reflectoring.staticular.githubapp.client.api.model;

import lombok.Value;

/**
 * A JWT used to interact with a GitHub repository in the name and with the permissions
 * of a GitHub application the user has previously installed to this repository.
 */
@Value
public class GithubJwt {

  private final String value;

  @Override
  public String toString(){
    return this.value;
  }

}
