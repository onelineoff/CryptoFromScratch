package org.moyoman.crypto.decrypt.substitution;

import org.moyoman.crypto.dto.SubstitutionDto;

public class BruteForceProcessor implements SubstitutionProcessor {

	@Override
	public SubstitutionDto process(SubstitutionDto dto) {
		// TODO Implement this
		return dto;
	}

	@Override
	public String getPrintableName() {
		return "Brute force processor";
	}

}
