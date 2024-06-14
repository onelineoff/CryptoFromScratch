package org.moyoman.crypto.encrypt;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		output = rotationCipher.rotate(input, key);
		assertEquals("Khoor, Zruog.", output);
		
		key = 6;
		output = rotationCipher.rotate(input, key);
		assertEquals("Nkrru, Cuxrj.", output);
	}
}
