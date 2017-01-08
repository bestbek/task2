package kg.zensoft.module.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import kg.zensoft.helper.InputAsList;
import kg.zensoft.module.Module;

/**
 * @author Mickey
 */
public class ModuleImpl3 implements Module {

	private final Integer MAX_EDIT_DISTANCE = 1;

	private Integer inputLength;
	private Integer patternLength;
	private Set<String> results;

	@Override
	public Set<String> getMatchedStringsPerLine(InputAsList inputAsList) {
		results = new LinkedHashSet<String>();
		for (String input : inputAsList.getInputTexts()) {
			for (String pattern : inputAsList.getPatternTexts()) {
				setLengthsOfTextLines(input.length(), pattern.length()); 
				if (isLengthDifferenceMoreThanMaxEditDistance())
					continue;
				searchAndAddMatchedToResults(input, pattern);
			}
		}
		return results;
	}

	private void setLengthsOfTextLines(int inputLength, int patternLength) { // change name of method
		this.inputLength = inputLength;
		this.patternLength = patternLength;
	}

	private boolean isLengthDifferenceMoreThanMaxEditDistance() { 
		return Math.abs(patternLength - inputLength) > MAX_EDIT_DISTANCE;
	}

	private void searchAndAddMatchedToResults(final String input, final String pattern) {
		int counterOfEditDistance = 0;
		int indexOfInput = 0;
		int indexOfPattern = 0;
		
		while (indexOfInput < inputLength && indexOfPattern < patternLength) { //create method?
			if (input.charAt(indexOfInput) != pattern.charAt(indexOfPattern)) { // create method?
				if (counterOfEditDistance == MAX_EDIT_DISTANCE) {
					break;
				}
				if (patternLength > inputLength) {
					indexOfPattern++;
				} else if (patternLength < inputLength) {
					indexOfInput++;
				} else {
					indexOfInput++;
					indexOfPattern++;
				}
				counterOfEditDistance++;
			} else {
				indexOfInput++;
				indexOfPattern++;
			}
		}
		if (indexOfInput < inputLength || indexOfPattern < patternLength) {
			counterOfEditDistance++;
		}
		if (counterOfEditDistance <= MAX_EDIT_DISTANCE) {
			results.add(input);
		}
	}
}
