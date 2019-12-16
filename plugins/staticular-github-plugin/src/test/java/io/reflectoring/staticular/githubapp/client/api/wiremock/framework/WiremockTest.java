package io.reflectoring.staticular.githubapp.client.api.wiremock.framework;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class WiremockTest {

  private WireMockServer server;

  @BeforeEach
  public void setup() {
    server = new WireMockServer(port());
    server.start();
  }

  @AfterEach
  public void teardown() {
    server.stop();
  }

  public WireMockServer server() {
    return this.server;
  }

  int port() {
    return 8090;
  }

  public String givenBaseUrl() {
    return String.format("http://localhost:%d", port());
  }

}
