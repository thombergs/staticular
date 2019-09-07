package io.reflectoring.staticular.yaml;

import io.reflectoring.staticular.processor.ContentTransformer;
import io.reflectoring.staticular.processor.StaticFile;
import io.reflectoring.staticular.processor.UserContent;
import org.yaml.snakeyaml.Yaml;

class YamlTransformer implements ContentTransformer {

	@Override
	public StaticFile transformContent(UserContent userContent) {
		Yaml yaml = new Yaml();
		byte[] staticFileContent = yaml.dump(userContent.asMap()).getBytes();
		return new StaticFile(staticFileContent);
	}


}
