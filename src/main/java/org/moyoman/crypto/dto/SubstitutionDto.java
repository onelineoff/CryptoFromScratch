package org.moyoman.crypto.dto;

public class SubstitutionDto {
	public static final Character SENTINEL = '-';
	public String[] words;
	public char[] map;
	
	public SubstitutionDto(String[] words) {
		this.words = words;
		
		map = new char[26];
		for (int i=0; i<=25; i++) {
			map[i] = SENTINEL;
		}
	}

	public String[] getWords() {
		return words;
	}

	public char[] getMap() {
		return map;
	}	
}