package org.moyoman.crypto.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RandomUtils {
	SecureRandom random;
	
	public RandomUtils() {
		random = new SecureRandom();
	}
	
	/** Get a char map with each lower case letter in random order.
	 * 
	 * @return The random character map.
	 */
	public char[] getScrambledLetters() {
		char[] map = new char[26];
		List<Integer> indices = new ArrayList<>();
		for (Integer i=0; i<26; i++) {
			indices.add(i);
		}
		
		// Set the map in order, retrieve a number randomly from the indices,
		// remove that index from the list, and set the map value with the random offset.
		for (int i=0; i<26; i++) {
			int randomIndex = random.nextInt(26 - i);
			int offset = indices.get(randomIndex);
			map[i] = (char) ('a' + offset);
			indices.remove(randomIndex);
		}
		
		return map;
	}
}
