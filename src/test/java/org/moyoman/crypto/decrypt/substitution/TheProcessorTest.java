package org.moyoman.crypto.decrypt.substitution;

import org.junit.jupiter.api.Test;
import org.moyoman.crypto.dto.SubstitutionDto;
import org.moyoman.crypto.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class TheProcessorTest {
	@Autowired
	private TheProcessor theProcessor;
	@Autowired
	private StringUtils stringUtils;
	

	@Test
	public void testProcessor() {
		String plainText = stringUtils.getPlainText();
		String[] words = stringUtils.getWords(plainText);
		SubstitutionDto substitutionDto = new SubstitutionDto(words);
		theProcessor.process(substitutionDto);
		
		
		
	}
}
