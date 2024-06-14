package org.moyoman.crypto.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class DictionaryUtilsTest {

	@Autowired
	DictionaryUtils dictionaryUtil;
	
	@Test
	public void testDictionarySize() {
		int words = dictionaryUtil.getWordCount();
		assertTrue(words > 50000);
	}
	
	@Test
	public void testWords() {
		boolean isWord = dictionaryUtil.isWord("porcupine");
		assertTrue(isWord);
		
		isWord = dictionaryUtil.isWord("satisfactory");
		assertTrue(isWord);
		
		isWord = dictionaryUtil.isWord("wytqzepz");
		assertFalse(isWord);
	}
}
