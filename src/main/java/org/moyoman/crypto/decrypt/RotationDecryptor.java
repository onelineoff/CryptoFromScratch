package org.moyoman.crypto.decrypt;

import org.moyoman.crypto.encrypt.RotationCipher;
import org.moyoman.crypto.util.DictionaryUtils;
import org.moyoman.crypto.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Decryptor
@Service
public class RotationDecryptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(RotationDecryptor.class);
	
	@Autowired
	RotationCipher rotationCipher;
	@Autowired
	DictionaryUtils dictionaryUtil;
	@Autowired
	StringUtils stringUtils;
	
	public int decrypt(String encryptedStr) {
		
		/* For 0..25
		 * Split each potentially decrypted string by non alphabetic characters
		 * filter by matches in the dictionary.
		 * Get the count of the matches
		 * Get the key with the max count.
		 */
		
		int totalMatches = 0;
		int bestMatch = 0;
		String[] words = stringUtils.getWords(encryptedStr);
		for (String word : words) {
			if (dictionaryUtil.isWord(word)) {
				totalMatches++;
			}
		}
		
		for (int i=1; i<=25; i++) {
			String rotatedString = rotationCipher.rotate(encryptedStr, i);
			
			words = stringUtils.getWords(rotatedString);
			int currentMatches = 0;
			for (String word : words) {
				if (dictionaryUtil.isWord(word)) {
					currentMatches++;
				}
			}
			
			if (currentMatches > totalMatches) {
				LOGGER.info("{} matches for key {}", currentMatches, i);
				bestMatch = i;
				totalMatches = currentMatches;
			}
		}
		
		LOGGER.info("Found key of {} with {} matches", bestMatch, totalMatches);
		
		return bestMatch;
	}
	
	
}
