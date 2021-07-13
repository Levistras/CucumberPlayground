/*
 * Kangeyan Passoubady
 * Version 1.0
 */
package com.kavinschool.examples.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.StringFixedSaltGenerator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EncryptionUtils {
	/**
	 * The encryptor.
	 */
	private final StandardPBEStringEncryptor encryptor;

	/**
	 * Instantiates a new encryption tool.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public EncryptionUtils() throws IOException {
		this("encryption.properties");
	}

	/**
	 * Instantiates a new encryption tool.
	 *
	 * @param keyPath the key path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public EncryptionUtils(final String keyPath) throws IOException {
		final Properties prop = new Properties();
		final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(keyPath);
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("File not found: " + keyPath);
		}
		final String key = prop.getProperty("key");
		encryptor = new StandardPBEStringEncryptor();
		encryptor.setKeyObtentionIterations(1000);
		encryptor.setSaltGenerator(new StringFixedSaltGenerator("31542687"));
		encryptor.setPassword(key);
	}

	/**
	 * Encrypt.
	 *
	 * @param plainText the un-encrypted string
	 * @return the string
	 */
	public String encrypt(final String plainText) {
		return encryptor.encrypt(plainText);
	}

	/**
	 * Decrypt the given encrypted string
	 *
	 * @param encryptedString the encrypted string
	 * @return the string
	 */
	public String decrypt(final String encryptedString) {
		return encryptor.decrypt(encryptedString);
	}

}
