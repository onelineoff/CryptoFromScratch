package org.moyoman.crypto.decrypt;

import java.util.List;

import org.moyoman.crypto.decrypt.substitution.SubstitutionProcessor;
import org.moyoman.crypto.dto.SubstitutionDto;
import org.moyoman.crypto.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Decryptor
@Service
public class SubstitutionDecryptor {
	@Autowired
	StringUtils stringUtils;
	
	private List<SubstitutionProcessor> processors;
	
	public SubstitutionDecryptor(List<SubstitutionProcessor> processors) {
		this.processors = processors;
	}
	
	public char[] decrypt(String input) {
		String[] words = stringUtils.getWords(input);
		SubstitutionDto substitutionDto = new SubstitutionDto(words);
		
		for (SubstitutionProcessor currProcessor : processors) {
			currProcessor.process(substitutionDto);
		}
		
		return substitutionDto.getMap();
	}

}
