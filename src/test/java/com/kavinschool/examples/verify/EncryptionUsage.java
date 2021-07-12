package com.kavinschool.examples.verify;

import java.io.IOException;

import com.kavinschool.examples.utils.EncryptionUtils;

public class EncryptionUsage {
	public static void main(String[] args) throws IOException {
		String password = "MySecretIsNotThatSecret";

		EncryptionUtils encryptionUtils = new EncryptionUtils();
		String encrypted = encryptionUtils.encrypt(password);
		System.out.println("encrypted = " + encrypted);

		String decrypted = encryptionUtils.decrypt(encrypted);
		System.out.println("decrypted = " + decrypted);
	}
}
