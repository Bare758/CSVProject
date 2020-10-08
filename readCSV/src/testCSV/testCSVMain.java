package testCSV;

import javax.swing.SwingUtilities;

public class testCSVMain {

	public static void main(String[] args) {

		UserInterface ui = new UserInterface();

		readCSV.getWholeSheet();
		//readCSV.printCSV();
		SwingUtilities.invokeLater(ui);

	}

}