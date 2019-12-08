package io.reflectoring.staticular.githubapp.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

interface CreateFile {

	@Headers({
			"Content-Type: application/json",
			"Authorization: Bearer {token}"
	})
	@RequestLine("PUT /repos/{owner}/{repo}/contents/{filename}")
	void createFile(
			CreateFileRequestBody body,
			@Param("token") String token,
			@Param("owner") String owner,
			@Param("repo") String repo,
			@Param("filename") String filename);

}
