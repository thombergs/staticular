package io.reflectoring.staticular.processor;

import io.reflectoring.staticular.spi.ContentPublisherPlugin;
import io.reflectoring.staticular.spi.ContentTransformerPlugin;
import io.reflectoring.staticular.spi.PluginId;
import java.util.ServiceLoader;

/**
 * Contains all configuration that influences the path from submitted user content to a published static file.
 */
public class SiteConfiguration {

  private final PluginId YAML_TRANSFORMER_ID = new PluginId("yaml");
  private final PluginId GITHUB_PUBLISHER_ID = new PluginId("github");

  private ServiceLoader<ContentTransformerPlugin> transformerServiceLoader = ServiceLoader.load(
      ContentTransformerPlugin.class);
  private ServiceLoader<ContentPublisherPlugin> contentPublisherServiceLoader = ServiceLoader.load(
      ContentPublisherPlugin.class);

  public ContentTransformerPlugin transformer() {
    // TODO: load plugin from configuration instead of always loading the first
    return transformerServiceLoader.stream()
        .filter(transformer -> transformer.get().id().equals(YAML_TRANSFORMER_ID))
        .findFirst()
        .get().get();
  }

  public ContentPublisherPlugin publisher() {
    // TODO: load plugin from configuration instead of always loading the first
    return contentPublisherServiceLoader.stream()
        .filter(publisher -> publisher.get().id().equals(GITHUB_PUBLISHER_ID))
        .findFirst()
        .get().get();
  }

}
