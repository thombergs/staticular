package io.reflectoring.staticular.spi;

import io.reflectoring.staticular.spi.model.StaticFile;
import io.reflectoring.staticular.spi.model.UserContent;

public interface ContentTransformerPlugin {

	PluginId id();

	/**
	 * Transforms user-generated content into a static file.
	 */
	StaticFile transformContent(UserContent userContent);

}
