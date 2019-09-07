package io.reflectoring.staticular.githubapp.client;

import java.util.Base64;

import lombok.Getter;
import lombok.Value;

@Getter
class CreateFileRequestBody {

	private final String commitMessage;
	private final Committer committer;
	private final String content;

	public CreateFileRequestBody(String commitMessage, Committer committer, String content) {
		this.commitMessage = commitMessage;
		this.committer = committer;
		this.content = Base64.getEncoder().encodeToString(content.getBytes());
	}

	@Value
	static class Committer{
		private String name;
		private String email;
	}
}
