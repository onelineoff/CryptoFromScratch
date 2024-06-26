package org.moyoman.crypto.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
/** This class provides utility methods for analyzing a sample of text.
 *  It provides answers to simple analysis of the input string, such as:
 *  which are the most common words?
 *  which are the most common bigrams?
 *  which are the most and least common letters?
 *  which letters are more or less likely to be the first character of a word?
 */
public class StringUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(StringUtils.class);
	
	public String getPlainText() {
		try {
			String dictPath = new ClassPathResource("plaintext1.txt").getFile().getAbsolutePath();
			Path path = Paths.get(dictPath);
			List<String> lines = Files.readAllLines(path);
			
			return String.join("\n", lines);
		} catch (IOException e) {
			LOGGER.warn("Unable to read plaintext", e);
			return "error";
		}
	}
	
	public String[] getWords(String input) {
		return input.split("\\s");
	}
	
	public char[] toUpperCase(char[] carr) {
		char[] retArr = new char[carr.length];
		for (int i=0; i<carr.length; i++) {
			retArr[i] = Character.toUpperCase(carr[i]);
		}
		
		return retArr;
	}
	
	public Map<String, Long> getWordCount(String[] words) {
		return Arrays.stream(words).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
	}
	
	public List<Entry<String, Long>> getMostCommonWordsWithCount(String[] words, int total) {
		return getWordCount(words).entrySet().stream().sorted((e1, e2) -> 
		{if (e1.getValue() > e2.getValue()) 
			return -1; 
		else if (e1.getValue() < e2.getValue()) 
			return 1; 
		else return 0;}).limit(total).toList();
	}
	
	public List<String> getMostCommonWords(String[] words, int limit) {
		List<String> wordList = new ArrayList<>();
		List<Entry<String, Long>> sortedList =  getMostCommonWordsWithCount(words, limit);
		sortedList.stream().forEach(e -> wordList.add(e.getKey()));
		return wordList;
	}
	
	public List<String> getMostCommonBigrams(String[] words, int total) {
		String[] bigramArray = new String[total];
		Object[] objArray = Arrays.stream(words).
				filter(w -> w.length() >= 2).
				filter(w -> Character.isLetter(w.charAt(0))).
				filter(w -> Character.isLetter(w.charAt(1))).
				map(w -> w.substring(0, 2)).
				map(w -> w.toLowerCase()).toArray();
		
		for (int i=0; i<total; i++) {
			bigramArray[i] = (String) objArray[i];
		}
		return getMostCommonWords(bigramArray, total);
	}
	
	public List<Character> getFirstCharacterMore(String[] words) {
		return null;
	}
	
	public List<Character> getFirstCharacterLess(String[] words) {
		return null;
	}
	
	
	
	
	
	
}
