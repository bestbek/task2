package kg.zensoft.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import kg.zensoft.helper.InputAsList;
import kg.zensoft.helper.TextFileAsList;
import kg.zensoft.module.Module;
import kg.zensoft.module.impl.ModuleImpl1;
import kg.zensoft.module.impl.ModuleImpl2;
import kg.zensoft.module.impl.ModuleImpl3;

/**
 * 
 * @author Mickey
 *
 */
public class Main {

	private static List<Module> modules = new ArrayList<>();

	public static void main(String[] args) {
		initializeModules();
		InputAsList inputAsList = new TextFileAsList();
		printModules(inputAsList);
	}

	private static void printModules(InputAsList inputAsList) {
		modules.forEach((module) -> {
			Set<String> results;
			results = module.getMatchedStringsPerLine(inputAsList);
			results.forEach((result) -> System.out.println(result));
			System.out.println("------------------");
		});

	}

	private static void initializeModules() {
		Module module1 = new ModuleImpl1();
		Module module2 = new ModuleImpl2();
		Module module3 = new ModuleImpl3();
		modules.add(module1);
		modules.add(module2);
		modules.add(module3);
	}
}
