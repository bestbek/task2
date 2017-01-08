package kg.zensoft.module;

import java.util.Set;

import kg.zensoft.helper.InputAsList;

/**
 * @author Mickey
 */
public interface Module {

	Set<String> getMatchedStringsPerLine(InputAsList inputAsList);
}
