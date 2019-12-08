package io.reflectoring.staticular.yaml;

import java.io.ByteArrayInputStream;
import java.util.Map;

import io.reflectoring.staticular.spi.model.Field;
import io.reflectoring.staticular.spi.model.StaticFile;
import io.reflectoring.staticular.spi.model.UserContent;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;
import static org.assertj.core.api.Assertions.*;

class YamlTransformerTest {

	@Test
	void transformsToYaml(){
		UserContent userContent = new UserContent()
				.addField(new Field("name", "bob"))
				.addField(new Field("text", "this is a user-generated comment"));

		YamlTransformerPlugin yamlTransformer = new YamlTransformerPlugin();

		StaticFile staticFile = yamlTransformer.transformContent(userContent);

		Yaml yaml = new Yaml();
		Map<String, String> document = yaml.load(new ByteArrayInputStream(staticFile.getContent()));

		assertThat(document.get("name")).isEqualTo("bob");
		assertThat(document.get("text")).isEqualTo("this is a user-generated comment");
	}

}