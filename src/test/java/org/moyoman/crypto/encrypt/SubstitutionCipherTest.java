package org.moyoman.crypto.encrypt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class SubstitutionCipherTest {
	@Autowired
	private SubstitutionCipher substitutionCipher;
	
	@Test
	public void testEncryption() {
		String plaintext = "Hello, world.";
		char[] key = {'l', 'd', 'y', 'a', 'f', 'n', 'w', 'b', 'k', 't', 'h', 'p', 'e', 'c', 'g', 'u', 'v', 'o', 'r', 'x', 'm', 'z', 's', 'j', 'q', 'i'};
		String encryptedText = substitutionCipher.encrypt(plaintext, key);
		String expectedOutput = "Bfppg, sgopa.";
		assertEquals(expectedOutput, encryptedText);
	}
	
}
