package org.moyoman.crypto.decrypt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.moyoman.crypto.encrypt.RotationCipher;
import org.moyoman.crypto.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
@ActiveProfiles("test")
public class RotationDecryptorTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(RotationDecryptorTest.class);
	
	@Autowired
	private RotationCipher rotationCipher;
	@Autowired
	private RotationDecryptor rotationDecryptor;
	@Autowired
	private	StringUtils StringUtils;
	
	@Test
	public void decryptPlainText() { 
		String plaintext = StringUtils.getPlainText();
		LOGGER.info("Plaintext length is {}", plaintext.length());
		assertTrue(plaintext.length() > 100);
		
		for (int key=1; key<26; key++) {
			String encryptedText = rotationCipher.rotate(plaintext, key);
			String decryptedText = rotationDecryptor.decrypt(encryptedText);
			assertFalse(plaintext.equals(encryptedText));
			assertEquals(plaintext, decryptedText);
		}
	}
}
