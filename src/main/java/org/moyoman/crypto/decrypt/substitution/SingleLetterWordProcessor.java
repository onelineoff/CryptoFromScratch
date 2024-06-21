package org.moyoman.crypto.decrypt.substitution;

import org.moyoman.crypto.dto.SubstitutionDto;

public class SingleLetterWordProcessor implements SubstitutionProcessor {

	@Override
	public SubstitutionDto process(SubstitutionDto dto) {
		// TODO Implement this
				return dto;
	}

	@Override
	public String getPrintableName() {
		return "Search for the single letter words a and I.";
	}

}
