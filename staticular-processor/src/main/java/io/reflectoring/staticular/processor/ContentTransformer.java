package io.reflectoring.staticular.processor;

public interface ContentTransformer {

	/**
	 * Transforms user-generated content into a static file.
	 */
	StaticFile transformContent(UserContent userContent);

}
