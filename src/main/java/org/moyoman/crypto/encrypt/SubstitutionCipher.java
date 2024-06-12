package org.moyoman.crypto.encrypt;

import org.springframework.stereotype.Service;

@Encryptor
@Service
/** Implement the simplest form of the substitution cipher.
 *  This works as follows:
 *  Each letter of the alphabet maps to a unique letter, which may be the same or different.
 *  All the letters in the plaintext message are output using the above mapping.
 *  All non-letters are passed through unchanged.
 *  Capitalization is not affected.
 *  
 *  There are 26 factorial possible key values.
 *  If letters must map to a different letter, this is reduced to 25 factorial.
 *  
 *  Clearly, this cannot be broken with the brute force approach, so more sophisticated
 *  cryptanalysis methods must be used.
 */
public class SubstitutionCipher {

		public String encrypt (String plainText, String key) {
			return null;
		}
		
		public DecipherResult decrypt(String encryptedText) {
			return null;
		}
}
