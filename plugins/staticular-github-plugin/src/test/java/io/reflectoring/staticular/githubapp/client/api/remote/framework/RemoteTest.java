package io.reflectoring.staticular.githubapp.client.api.remote.framework;

public class RemoteTest {

  protected RemoteTestProperties properties(){
    return RemoteTestPropertiesLoader.load();
  }

}
