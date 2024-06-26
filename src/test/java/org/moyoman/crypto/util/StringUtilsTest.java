package org.moyoman.crypto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class StringUtilsTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(StringUtilsTest.class);
	
	@Autowired
	private StringUtils stringUtils;
	
	@Test
	public void testGetPlaintext() {
		String text = stringUtils.getPlainText();
		assertTrue(text.length() > 1000);
	}
	
	@Test
	public void testGetWords() {
		String[] words = stringUtils.getWords(stringUtils.getPlainText());
		assertTrue(words.length > 100);
	}
	
	@Test
	public void testGetCommonWords() {
		List<String> words = stringUtils.getMostCommonWords(stringUtils.getWords(stringUtils.getPlainText()), 20);
		assertEquals(20, words.size());
		assertTrue(words.contains("to"));
		assertTrue(words.contains("the"));
		assertTrue(words.contains("she"));
		assertTrue(words.contains("and"));
		assertTrue(words.contains("that"));
	}
	
	@Test
	public void testGetMostCommonBigrams() {
		List<String> words = stringUtils.getMostCommonBigrams(stringUtils.getWords(stringUtils.getPlainText()), 10);
		LOGGER.info("Most common bigrams are {}", words);
	}
	
}
