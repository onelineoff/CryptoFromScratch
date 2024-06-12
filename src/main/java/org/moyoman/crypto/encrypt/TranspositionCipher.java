package org.moyoman.crypto.encrypt;

import org.springframework.stereotype.Service;

@Encryptor
@Service
/** Implement a very simple transposition cipher.
 *  This works as follows:
 *  A table is created where the letters of the key are the first row.
 *  The second row is the position of each letter in the alphabet, regardless of capitalization.
 *  The plain text message is now written out in rows the same length as the key
 *  from left to right, top to bottom.
 *  If the last line is not complete, use a padding character at the end.  
 *  This does  not affect the security of the encryption.
 *  
 *  This is about the simplest transposition algorithm.  There are more complex forms, 
 *  such as the rail cipher and route cipher, which may be added at some future time.
 *  
 * https://en.wikipedia.org/wiki/Transposition_cipher
 */
public class TranspositionCipher {
	public String encrypt (String plainText, String key) {
		return null;
	}
	
	public DecipherResult decrypt(String encryptedText) {
		return null;
	}
}
