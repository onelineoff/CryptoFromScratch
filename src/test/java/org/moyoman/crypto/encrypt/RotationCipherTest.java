package org.moyoman.crypto.encrypt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class RotationCipherTest {

	@Autowired
	public RotationCipher rotationCipher;
	
	@Test
	public void testRotation() {
		String input = "Hello, World.";
		int key = 3;
		String output = rotationCipher.rotate(input, key);
		assertEquals("Khoor, Zruog.", output);
		key=29;
		try {
			rotationCipher.rotate(input, key);
			fail("Key must be in range 1 - 25");
		}
		catch (IllegalArgumentException e) {
			// Expected behavior, don't need to do anything.
		}

		key = 6;
		output = rotationCipher.rotate(input, key);
		assertEquals("Nkrru, Cuxrj.", output);
	}
}
