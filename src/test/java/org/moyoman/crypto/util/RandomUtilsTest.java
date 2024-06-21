package org.moyoman.crypto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class RandomUtilsTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomUtilsTest.class);
	
	@Autowired
	private RandomUtils randomUtils;
	
	@Test
	public void testRandomMappingCorrect() {
		generateRandomMappingString();
	}
	
	@Test
	public void testRandomMappingUniqueness() {
		Set<String> mappingSet = new HashSet<>();
		int total = 10000;
		for (int i=0; i<total; i++) {
			assertTrue(mappingSet.add(generateRandomMappingString()));
		}
		
		assertEquals(total, mappingSet.size());
	}
	
	private String generateRandomMappingString() {
		char[] map = randomUtils.getScrambledLetters();
		StringBuffer sb = new StringBuffer();
		for (char c : map) {
			sb.append(c);
			sb.append(" ");
		}
		
		String mappingString = sb.toString();
		LOGGER.info(mappingString);
		assertEquals(26, map.length);
		
		for (int offset=0; offset<26; offset++) {
			char c = (char) ('a' + offset);
			assertTrue(mappingString.indexOf(c) >= 0);
		}
		
		return mappingString;
	}
}
