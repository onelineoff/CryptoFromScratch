package org.moyoman.crypto.decrypt.substitution;

import org.moyoman.crypto.dto.SubstitutionDto;

public class WProcessor implements SubstitutionProcessor {

	@Override
	public SubstitutionDto process(SubstitutionDto dto) {
		// TODO Implement this
		return dto;
	}

	@Override
	public String getPrintableName() {
		return "Single letter processor for w.";
	}

}
