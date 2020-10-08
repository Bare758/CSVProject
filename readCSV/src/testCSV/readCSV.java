package testCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class readCSV {

	private static String COMMA_DELIMITER = ",";
	private static ArrayList<ArrayList<String>> wholeSheet = new ArrayList<>();
	static String myString = "";
	static String container = "";
	static boolean recieve = false;

	public static ArrayList<ArrayList<String>> getWholeSheet() {

		if (wholeSheet.isEmpty()) {
			loadCSV();
		}

		return wholeSheet;

	}

	// connects the csv file
	public static void loadCSV() {

		try (Scanner scanner = new Scanner(new File("sample.csv"));) {
			while (scanner.hasNext()) {

				wholeSheet.add(getRows(scanner.nextLine()));

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		for (int i = 0; i < wholeSheet.size(); i++) {
			// loops through values
			List<String> localValues = wholeSheet.get(i);
			//System.out.println(localValues.size());
		}

	}

	private static ArrayList<String> getRows(String row) {

		ArrayList<String> rowValues = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(row)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);

			while (rowScanner.hasNext()) {

				myString = rowScanner.next();

				container += myString;
				if (!myString.isEmpty()) {
					if (myString.charAt(0) == '"') {
						recieve = true;
						continue;
					}
				}
				if (!container.isEmpty()) {
					if (container.charAt((container.length() - 1)) == '"') {
						recieve = false;
					}
				}

				rowValues.add(container);

				if (!recieve) {
					container = "";
				}
			}

			return rowValues;
		}

	}

	public static void printCSV() {
		for (ArrayList<String> row : wholeSheet) {

			//System.out.println(row);

		}

	}

}