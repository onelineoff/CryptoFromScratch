package org.moyoman.crypto.decrypt.substitution;

import java.util.HashMap;
import java.util.Map;

import org.moyoman.crypto.dto.SubstitutionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/** Attempt to set the letters t, h, and e by looking for the word the.
 *  There are no preconditions required to run this processor.
 */
@Component
public class TheProcessor implements SubstitutionProcessor {
	private static final Logger LOGGER = LoggerFactory.getLogger(TheProcessor.class);
	
	private Map<String, Integer> wordCount = new HashMap<>();
	
	@Override
	public SubstitutionDto process(SubstitutionDto dto) {
		for (String word : dto.getWords()) {
			Integer count = wordCount.get(word);
			if (count == null) {
				count = 1;
			}
			else {
				count++;
			}
			wordCount.put(word, count);
		}
		
		String mostCommonWord = wordCount.entrySet().stream().filter(e -> e.getKey().length() == 3).
				max((e1, e2) -> e2.getValue() > e1.getValue() ? -1 : 1).get().getKey();
		LOGGER.info("The is {}", mostCommonWord);
		
		/* TODO The current implementation assumes that the is the most common 3 letter word.
		This could be made more resilient by looking at the top 5 or 10 words in case the is not the most common.
		The following checks are done:		
		th is one of the most popular bigrams, verify that this is the case for the first two letters.
		he is also a very popular bigram.  Verify that this is the case for the last two letters.
		e is very common, t is less common, and h is much less common.  Verify these conditions for the three letters.
		e is less common as the first letter of a word.  Verify this for the last letter.
		
		If all the above conditions are true, set the t, h, and e letters. Otherwise, leave them unchanged.
		 */
		return dto;
	}

	@Override
	public String getPrintableName() {
		return "Set the letters t, h, and e by looking for the word the.";
	}
}
