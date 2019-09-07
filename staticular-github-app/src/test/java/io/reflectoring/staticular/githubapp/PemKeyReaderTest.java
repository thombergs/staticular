package io.reflectoring.staticular.githubapp;

import java.security.KeyPair;

import org.junit.jupiter.api.Test;
import static io.reflectoring.staticular.githubapp.RSAKeyTestData.*;
import static org.assertj.core.api.Assertions.*;

class PemKeyReaderTest {

	@Test
	void fromString_success() {
		KeyPair keyPair = PemKeyReader.fromString(validRSAPrivateKeyAsString());
		assertThat(keyPair).isNotNull();
	}


}