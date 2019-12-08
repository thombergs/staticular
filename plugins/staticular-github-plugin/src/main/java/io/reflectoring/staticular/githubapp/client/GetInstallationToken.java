package io.reflectoring.staticular.githubapp.client;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lombok.Getter;

public interface GetInstallationToken {

	@Headers({
			"Accept: application/vnd.github.machine-man-preview+json",
			"Authorization: Bearer {jwt}"
	})
	@RequestLine("POST /app/installations/{installationId}/access_tokens")
	InstallationToken getInstallationToken(
			@Param("jwt") String jwt,
			@Param("installationId") String installationId);

	@Getter
	class InstallationToken {

		private final String token;
		private final LocalDateTime expires_at;

		@JsonCreator
		public InstallationToken(
				@JsonProperty("token") String token,
				@JsonProperty("expires_at") LocalDateTime expires_at) {
			this.token = token;
			this.expires_at = expires_at;
		}
	}
}
