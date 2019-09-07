package io.reflectoring.staticular.githubapp;

import java.io.IOException;
import java.io.StringReader;
import java.security.KeyPair;

import org.bouncycastle.openssl.PEMReader;


public class PemKeyReader {

	private PemKeyReader() {
	}

	static {
		initBouncyCastle();
	}

	private static void initBouncyCastle() {
		java.security.Security.addProvider(
				new org.bouncycastle.jce.provider.BouncyCastleProvider()
		);
	}

	/**
	 * Reads an RSA private key from a PEM file.
	 */
	public static KeyPair fromString(String pemString) {
		try {
			return (KeyPair) new PEMReader(new StringReader(pemString)).readObject();
		} catch (IOException e) {
			throw new PemKeyReaderException("error while trying to read private key from PEM source", e);
		}
	}

	public static class PemKeyReaderException extends RuntimeException {
		PemKeyReaderException(String message, Throwable cause) {
			super(message, cause);
		}
	}


}
