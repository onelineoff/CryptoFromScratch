package org.moyoman.crypto.decrypt.substitution;

import java.util.ArrayList;
import java.util.List;

public class SubstitutionDecryptorOrchestrator {
	private static List<SubstitutionProcessor> processorList;
	
	static {
		processorList = new ArrayList<>();
		processorList.add(new TheProcessor());
		processorList.add(new SingleLetterWordProcessor());
		processorList.add(new WProcessor());
		processorList.add(new BProcessor());
		processorList.add(new OProcessor());
		processorList.add(new FProcessor());
		processorList.add(new NProcessor());
		processorList.add(new RProcessor());
		processorList.add(new SProcessor());
		processorList.add(new YUProcessor());
		processorList.add(new DProcessor());
		processorList.add(new HProcessor());
		processorList.add(new BruteForceProcessor());
	}
	
	public static List<SubstitutionProcessor> getStandardProcessorList() {
		return processorList;
	}
}
