package org.moyoman.crypto.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class DictionaryUtils {
	private Set<String> words;
	
	public DictionaryUtils() throws IOException { 
		String dictPath = new ClassPathResource("dict.txt").getFile().getAbsolutePath();
		Path path = Paths.get(dictPath);
		List<String> lines = Files.readAllLines(path);
		words = new HashSet<>(lines);
	}
	
	public int getWordCount() {
		return words.size();
	}
	
	public boolean isWord(String word) {
		return words.contains(word);
	}
}
