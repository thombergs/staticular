package io.reflectoring.staticular.processor.common;

/**
 * Thrown when a configuration property is not valid for some reason.
 */
public class ConfigurationException extends RuntimeException {

	public ConfigurationException(String configurationPropertyName, Object configurationPropertyValue) {
		super(message(configurationPropertyName, configurationPropertyValue));
	}

	public ConfigurationException(String configurationPropertyName, Object configurationPropertyValue, Throwable cause) {
		super(message(configurationPropertyName, configurationPropertyValue), cause);
	}

	private static String message(String configurationPropertyName, Object configurationPropertyValue) {
		return String.format("Error with configuration property '%s' (set to '%s'). Please check your configuration", configurationPropertyName, configurationPropertyValue);
	}
}
