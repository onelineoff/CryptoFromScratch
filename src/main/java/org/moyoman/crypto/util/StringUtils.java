package org.moyoman.crypto.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
}
