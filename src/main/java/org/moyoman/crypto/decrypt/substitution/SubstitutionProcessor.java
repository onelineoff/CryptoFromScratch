package org.moyoman.crypto.decrypt.substitution;

import org.moyoman.crypto.dto.SubstitutionDto;

/** Classes which implement this interface try to determine the mapping of some of the unset letters.
 *  These classes should not make conflicting changes to any letter that are already set.
 *  
 *  As a possible future enhancement, some mechanism could be added for adjudicating among conflicting
 *  analysis among the various processors.  For now, first one to set the letter wins.
 */
public interface SubstitutionProcessor {
	public SubstitutionDto process(SubstitutionDto dto);
	public String getPrintableName();
}
