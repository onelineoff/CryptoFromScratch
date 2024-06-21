package org.moyoman.crypto.encrypt;

import java.util.Arrays;

import org.moyoman.crypto.util.RandomUtils;
import org.moyoman.crypto.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(SubstitutionCipher.class);
	
	@Autowired
	private RandomUtils randomUtils;
	@Autowired
	private StringUtils stringUtils;
	
		public String encrypt (String plaintext, char[] lowerMapping) {
			char[] upperMapping = stringUtils.toUpperCase(lowerMapping);
			
			char[] carr = plaintext.toCharArray();
			for (int i=0; i<carr.length; i++) {
				char c = carr[i];
				
				if (Character.isLowerCase(c)) {
					int offset = c - 'a';
					carr[i] = lowerMapping[offset];
				}
				else if (Character.isUpperCase(c)) {
					int offset = c - 'A';
					carr[i] = upperMapping[offset];
				}
			}
			
			
			String encryptedString = new String(carr);
			LOGGER.info("Encrypted string is {}", encryptedString);
			return encryptedString;
		}
		
		public DecipherResult decrypt(String encryptedText) {
			return null;
		}
}
