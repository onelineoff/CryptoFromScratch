package org.moyoman.crypto.decrypt.substitution;

import org.moyoman.crypto.dto.SubstitutionDto;

public class DProcessor implements SubstitutionProcessor {

	@Override
	public SubstitutionDto process(SubstitutionDto dto) {
		// TODO Implement this
		return dto;
	}

	@Override
	public String getPrintableName() {
		return "Single letter processor for d.";
	}

}
