package io.reflectoring.staticular.githubapp;

import java.security.PrivateKey;
import java.security.PublicKey;

class RSAKeyTestData {

	private static final String PEM_KEY_STRING = "-----BEGIN RSA PRIVATE KEY-----\n" +
			"MIIEowIBAAKCAQEAp9dQ+W5p+wkx+8erwlFfd1ayWkG/LeTQTRDxuTA0p38VNQD1\n" +
			"5Sg5sWHd161gkXEWCsFfVAJBwIG4E1SkN4WWwgSrnT81RFticU+ZFBl+dOFN2V3W\n" +
			"WjIM+gEswXv2ErR/ZIQGBMT2jVPyP5tA7bFYUy/6aTuPhw33TFVs6HX6Wk0NBKL3\n" +
			"2xzzhLOrtZxOCXNa6yHqklPZxhEDEfqCLjHAw/zdwJaFzsX2h3LulcTPrs0XFPJU\n" +
			"mchvSM4QOuioFSHmTLFk4gcupJocyiwws6K7mpzBVDIpPVr9KO59M0cU1z+w2fCS\n" +
			"lUSFX2WqMAcGsLXNh1X7AEpFDNlKq9bKGIosZwIDAQABAoIBABCVyj6bloVj5ziG\n" +
			"BobxG4njW0Rn8shKL/stjXVLOijC+gl+ys2WJ/1LOmyxiTVWA2OUsCLRBkZLizD9\n" +
			"0CxcWwVZCMxFDrJuhU/FGc9OpZxPFy4/g4ruHzIlI5MK+MnoZB4+nYmjHOniPbHj\n" +
			"WYsjVyMBPrFfXVNvIdy9JEHkRpTdl0tvJRU35zQqs0t9UcJVPKxhHCQhhNHB2rB7\n" +
			"6qGpQm8+W0/vgAYGEeV4LOu6HOirn39uS9B3KwIZB3pl9nxiCU6HKfmkqYMor2X2\n" +
			"iXaOehyCbM37GzqMvDm14C76JarRGvpx/fObtFlbDNlqg5XxiCb+lmaoLGr4ry5g\n" +
			"gzChsYECgYEA1b6KpvSqHT3JGcrhuD30oVc4Cml6Bt9sBohZjY65VDs5usjqV8fN\n" +
			"xBTWvq1A1HU3EtNV/Gf4+auI60YOTCyT/P4zJqUv8NwS3OjgC7Pz7Xpc2jEkEX3F\n" +
			"9X/oRks2Mwrye1MHbQMHy3ZVtyEKhqOgmbmXeqsohCFdYnO4PqFNQzECgYEAyQWk\n" +
			"jNBuPBriDXti759CrX8hCivKIdUlNLyZZpEV6PTi+exVsEJ/tgYOakJeAcGM1sEk\n" +
			"/fSoRBJv7ua5Hk5dTQ85wZr6OEGQKVJvvqaBFNjB09R4xwpgG3yqvrMpNRckV7L9\n" +
			"DfKgWE6ZvrOd50lw/RKTwMwYnnul4e5ySaREkxcCgYBgIkbyOHCankNomltTJmp0\n" +
			"dmn6JN6BYNORTJoalOq9+7VHUT41JORjIIxFTl8uL1oJ2Yt+7rSIdqIqT2P21sXo\n" +
			"r9wJsZoSVqkVOpgqK1G2qaZBbICwbUUv2ct6cjF6W54b4Yghe49x71M1/mJhlA6T\n" +
			"lWmP/pNGeksqEKn5YUsCwQKBgQCzK6lfrQMj5V4oYBpts4ittQsQ0rjl8OGpoJQl\n" +
			"vBlIOsT3t3MkmBDWf41nnmHFtOrAGwTKqb80dS55RAIphfVZEsIK0wRFEgLZIdXh\n" +
			"muygVRZlpRJFbfT9at+Q+4U2Abttw2YTgXbzXpNgSx3poSbpGh7Bj+g9kb3noy0Q\n" +
			"gC5y3wKBgHSh1+7qz4r+uUZTMCt/gB2VK9Mh/04f0z0tCgVyh4bwfEeqKp5UmbF9\n" +
			"G0GPPZthjhUExmXinbEAawRwNNJRNR/nAQKclofdI1vJWoxPajxCvp5gK57b+LSf\n" +
			"YoD7NlaESNEBvG2wFLe/IFecMxevViwA8yCctudxwzJiCns0kScw\n" +
			"-----END RSA PRIVATE KEY-----";

	static String validRSAPrivateKeyAsString() {
		return PEM_KEY_STRING;
	}

	static PrivateKey validRSAPrivateKey(){
		return PemKeyReader.fromString(PEM_KEY_STRING).getPrivate();
	}

	static PublicKey validRSAPublicKey(){
		return PemKeyReader.fromString(PEM_KEY_STRING).getPublic();
	}
}
