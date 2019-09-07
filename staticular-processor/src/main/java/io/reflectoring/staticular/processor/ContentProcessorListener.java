package io.reflectoring.staticular.processor;

public interface ContentProcessorListener {

	void onBeforeTransform(UserContent userContent);

	void onAfterTransform(StaticFile staticFile);

	void onBeforePublish(StaticFile staticFile);

	void onAfterPublish(StaticFile staticFile);

}
