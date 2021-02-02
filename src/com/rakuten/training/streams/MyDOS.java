package com.rakuten.training.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MyDOS {

	static String commandName;
	static String arg1;
	static String arg2;

//
//	private static ChemicalElements[] elementsArray = { new ChemicalElements("Hydrogen", "H", 1),
//			new ChemicalElements("Postassium", "K", 19), new ChemicalElements("Oxygen", "O", 8) };
//
//	private static List<ChemicalElements> elementList = Arrays.asList(elementsArray);

//
	private static void inferCommandArguments(String[] arguments) {
		if (arguments.length == 0)
			return;
		commandName = arguments[0];
		arg1 = arguments[1];
		if (arguments.length > 2)
			arg2 = arguments[2];
	}

	private static void RecursivePrintAllSubDirs(File[] arr, int index) {
		if (index == arr.length)
			return;
		if (arr[index].isFile())
			System.out.println("File: " + arr[index].getName());
		else if (arr[index].isDirectory()) {
			System.out.println("Directory: " + arr[index].getName());
			RecursivePrintAllSubDirs(arr[index].listFiles(), 0);

		}
		RecursivePrintAllSubDirs(arr, ++index);
	}

	private static void dir() {
		File f = new File(arg1);
		if (f.exists() && f.isDirectory()) {
			File arr[] = f.listFiles();
			RecursivePrintAllSubDirs(arr, 0);
		}
	}

	private static void copy() {
		try {
			FileInputStream fis = new FileInputStream(arg1);
			FileOutputStream fos = new FileOutputStream(arg2);

			int b;
			while ((b = fis.read()) != -1) {
				fos.write(b);
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException " + e.getMessage());
		}
	}

	private static void type() {
		try {
			int ch;
			FileReader fr = null;
			try {
				fr = new FileReader(arg1);
			} catch (FileNotFoundException e) {
				throw e;
			}

			while ((ch = fr.read()) != -1) {
				System.out.println((char) ch);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound");
		} catch (IOException e) {
			System.out.println("FileNotFound");
		}
	}

	public static void main(String[] args) {
//		Stream.of(elementList);
//		System.out.println("stream.of called");
//		elementList.stream().forEach(e -> System.out.println("Name of element: " + e.getName()));
//
		if (args.length > 0) {
			inferCommandArguments(args);

			System.out.println(commandName);
			switch (commandName) {
			case "dir":
				dir();
				break;
			case "copy":
				copy();
				break;
			case "type":
				type();
				break;
			default:
				break;
			}
		}
	}

}
