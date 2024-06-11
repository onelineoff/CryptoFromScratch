package org.moyoman.crypto.cipher;

import org.springframework.stereotype.Service;

@Cipher
@Service
/** Very simplistic encryption by rotating the letters based on a key of 0 - 25.
 * With a key of 3 a -> d, b-> e, ..., x -> a, y -> b, z -> c.
 *  <A href="https://en.wikipedia.org/wiki/Caesar_cipher">Caesar Cipher</A>
 */
public class RotationCipher {

	private static char[] LOWER_ARRAY = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	private static char[] UPPER_ARRAY = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S','T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

	public String rotate(String input, int key) {
		// TODO rewrite using FP

		char[] charArr = input.toCharArray();
		for (int i=0; i<charArr.length; i++) {
			char currChar = charArr[i];
			if (Character.isLowerCase(currChar)) {
				int offset = (currChar - 'a' + key) % 26;
				charArr[i] = LOWER_ARRAY[offset];
			}
			else if (Character.isUpperCase(currChar)) {
				int offset = (currChar - 'A' + key) % 26;
				charArr[i] = UPPER_ARRAY[offset];
			}
			// Non alphabetic characters would remain unchanged.
		}
		
		return new String(charArr);
	}
}
