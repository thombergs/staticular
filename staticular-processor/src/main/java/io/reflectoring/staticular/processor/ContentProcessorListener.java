package io.reflectoring.staticular.processor;

import io.reflectoring.staticular.spi.model.StaticFile;
import io.reflectoring.staticular.spi.model.UserContent;

public interface ContentProcessorListener {

	void onBeforeTransform(UserContent userContent);

	void onAfterTransform(StaticFile staticFile);

	void onBeforePublish(StaticFile staticFile);

	void onAfterPublish(StaticFile staticFile);

}
