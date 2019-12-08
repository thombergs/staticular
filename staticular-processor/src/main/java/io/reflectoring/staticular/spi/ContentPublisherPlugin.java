package io.reflectoring.staticular.spi;

import io.reflectoring.staticular.spi.model.StaticFile;

public interface ContentPublisherPlugin {

	PluginId id();

	void publishContent(StaticFile staticFile);

}
