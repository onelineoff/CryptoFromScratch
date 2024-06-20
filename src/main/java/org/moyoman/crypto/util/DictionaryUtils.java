package org.moyoman.crypto.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
/** This contains a series of methods for processing English language words and features.
 * 
 *  This is independent of any particular user input, it is meant to analyze the English
 *  language in general, with tests for questions such as:
 *  which are the most common words?
 *  which are the most common bigrams?
 *  which are the most and least common letters?
 *  which letters are more or less likely to be the first character of a word?
 */
public class DictionaryUtils {
	private Set<String> words;
	private List<String> commonWords;
	private List<String> commonBigrams;
	private List<Character> firstLetterMore;
	private List<Character> firstLetterLess;
	
	public DictionaryUtils() throws IOException { 
		Path path = Paths.get(new ClassPathResource("dict.txt").getFile().getAbsolutePath());
		
		List<String> lines = Files.readAllLines(path);
		words = new HashSet<>(lines);
		
		path = Paths.get(new ClassPathResource("words.txt").getFile().getAbsolutePath());
		commonWords = Files.readAllLines(path);
		
		path = Paths.get(new ClassPathResource("bigrams.txt").getFile().getAbsolutePath());
		String text = Files.readAllLines(path).get(0);
		String[] sarr = text.split(",");
		commonBigrams = new ArrayList<>();
		for (String currStr : sarr) {
			commonBigrams.add(currStr);
		}
		
		path = Paths.get(new ClassPathResource("first_letter_more.txt").getFile().getAbsolutePath());
		text = Files.readAllLines(path).get(0);
		sarr = text.split(",");
		firstLetterMore = new ArrayList<>();
		for (String currStr : sarr) {
			firstLetterMore.add(currStr.charAt(0));
		}
		
		path = Paths.get(new ClassPathResource("first_letter_less.txt").getFile().getAbsolutePath());
		text = Files.readAllLines(path).get(0);
		sarr = text.split(",");
		firstLetterLess = new ArrayList<>();
		for (String currStr : sarr) {
			firstLetterLess.add(currStr.charAt(0));
		}
	}
	
	public int getWordCount() {
		return words.size();
	}
	
	public boolean isWord(String word) {
		return words.contains(word);
	}
	
	public List<String> getMostCommonWords(){
		
		return commonWords;
	}
	
	public List<String> getMostCommonBigrams(){

		return commonBigrams;
	}
	
	public List<Character> getFirstCharacterMore() {
		return firstLetterMore;
	}

	public List<Character> getFirstCharacterLess() {
		return firstLetterLess;
	}
}
