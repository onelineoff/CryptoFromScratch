package org.moyoman.crypto.encrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Encryptor
@Service
/** Very simplistic encryption by rotating the letters based on a key of 1 - 25.
 * With a key of 3 a -> d, b-> e, ..., x -> a, y -> b, z -> c.
 *  <A href="https://en.wikipedia.org/wiki/Caesar_cipher">Caesar Cipher</A>
 */
public class RotationCipher {
	private static final Logger LOGGER = LoggerFactory.getLogger(RotationCipher.class);
	
	/** Convert the input to the encrypted value by rotating to the right.
	 * 
	 * @param input The plaintext input
	 * @param key The amount to rotate to the right
	 * @return The encrypted string.
	 */
	public String rotate(String input, int key) {
		if (key <= 0 || key > 26) {
			String msg = String.format("In rotation cipher, key needs to be in the range 1 - 25, got %d", key);
			LOGGER.warn(msg);
			throw new IllegalArgumentException(msg);
		}
		
		// TODO Rewrite with FP
		char[] charArr = input.toCharArray();
		for (int i=0; i<charArr.length; i++) {
			if (Character.isLetter(charArr[i])) {
				char firstChar = 'a';
				if (Character.isUpperCase(charArr[i])) {
					firstChar = 'A';
				}

				int offset = (charArr[i] - firstChar + key) % 26;
				charArr[i] = (char) (firstChar + offset);
			}
		}

		// Non alphabetic characters would remain unchanged.

		String encryptedStr =  new String(charArr);
		LOGGER.debug("Encrypted string is {}", encryptedStr);
		return encryptedStr;
	}
}
