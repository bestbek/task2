package kg.zensoft.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Mickey
 *
 */
public class TextFileAsList implements InputAsList {

	private Scanner scannerOfInput;
	private Scanner scannerOfPattern;
	private List<String> inputsText;
	private List<String> patternsText;

	public TextFileAsList() {
		initialize();
	}

	private void initialize() {
		initializeScanners();
		initializeLists();
	}

	private void initializeScanners() {
		try {
			scannerOfPattern = new Scanner(new File("pattern.txt"));
			scannerOfInput = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void initializeLists() {
		inputsText = new ArrayList<>();
		while (getScannerForInput().hasNextLine()) {
			inputsText.add(getScannerForInput().nextLine());
		}
		patternsText = new ArrayList<>();
		while (getScannerForPattern().hasNextLine()) {
			patternsText.add(getScannerForPattern().nextLine());
		}
	}

	private Scanner getScannerForInput() {
		return scannerOfInput;
	}

	private Scanner getScannerForPattern() {
		return scannerOfPattern;
	}

	@Override
	public List<String> getInputTexts() {
		return inputsText;
	}

	@Override
	public List<String> getPatternTexts() {
		return patternsText;
	}

}
