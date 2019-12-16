package io.reflectoring.staticular.githubapp.client;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Feign;
import feign.Logger.Level;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;

public class ClientFactory {

	private final ObjectMapper objectMapper;

	public ClientFactory() {
		this.objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	public <T> T createClient(Class<T> clientClass, String baseUrl) {
		return Feign.builder()
				.decoder(new JacksonDecoder(objectMapper))
				.logger(new Slf4jLogger(clientClass))
				.logLevel(Level.FULL)
				.target(clientClass, baseUrl.replace("\\/$", ""));
	}

}
