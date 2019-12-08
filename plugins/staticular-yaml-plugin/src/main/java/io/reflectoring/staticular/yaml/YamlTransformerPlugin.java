package io.reflectoring.staticular.yaml;

import io.reflectoring.staticular.spi.ContentTransformerPlugin;
import io.reflectoring.staticular.spi.PluginId;
import io.reflectoring.staticular.spi.model.StaticFile;
import io.reflectoring.staticular.spi.model.UserContent;
import org.yaml.snakeyaml.Yaml;

class YamlTransformerPlugin implements ContentTransformerPlugin {

	@Override
	public PluginId id() {
		return new PluginId("yaml");
	}

	@Override
	public StaticFile transformContent(UserContent userContent) {
		Yaml yaml = new Yaml();
		byte[] staticFileContent = yaml.dump(userContent.asMap()).getBytes();
		return new StaticFile(staticFileContent);
	}


}
