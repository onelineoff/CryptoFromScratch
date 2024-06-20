package org.moyoman.crypto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

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
	
	
	@Test
	public void testCommonWords() {
		List<String> wordList = List.of("the", "of", "for", "one", "all");
		List<String> retrievedList = dictionaryUtil.getMostCommonWords();
		assertTrue(retrievedList.size() >= 50);

		for (String word : wordList) {
			assertTrue(retrievedList.contains(word));
		}
	}
	
	@Test
	public void testBigrams() {
		List<String> wordList = List.of("th", "es", "he", "in", "st");
		List<String> retrievedList = dictionaryUtil.getMostCommonBigrams();
		assertTrue(retrievedList.size() >= 10);

		for (String word : wordList) {
			assertTrue(retrievedList.contains(word));
		}
	}
	
	@Test
	public void testMoreCommonFirstLetters() {
		List<Character> moreCommonList = List.of('b', 'c', 'w', 'p', 'f', 'a', 't');
		List<Character> retrievedList = dictionaryUtil.getFirstCharacterMore();
		assertEquals(moreCommonList, retrievedList);
	}
	
	@Test
	public void testLessCommonFirstLetters() {
		List<Character> moreCommonList = List.of('j', 'e', 'n', 'y', 'u', 'r');
		List<Character> retrievedList = dictionaryUtil.getFirstCharacterLess();
		assertEquals(moreCommonList, retrievedList);
	}
}
