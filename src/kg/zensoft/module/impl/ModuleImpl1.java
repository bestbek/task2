package kg.zensoft.module.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import kg.zensoft.helper.InputAsList;
import kg.zensoft.module.Module;

/**
 * 
 * @author Mickey
 *
 */
public class ModuleImpl1 implements Module {

	private Set<String> results;

	@Override
	public Set<String> getMatchedStringsPerLine(InputAsList inputAsList) {
		results = new LinkedHashSet<String>();
		for (String input : inputAsList.getInputTexts()) {
			for (String pattern : inputAsList.getPatternTexts()) {
				if (input.equals(pattern)) {
					results.add(input);
				}
			}
		}
		return results;
	}
}
