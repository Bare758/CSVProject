package testCSV;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class UserInterface implements Runnable {

	private JFrame frame;
	private ArrayList<ArrayList<String>>myWholeSheet = readCSV.getWholeSheet();
	
	@Override
	public void run() {
		frame = new JFrame("Title");
		frame.setPreferredSize(new Dimension(200, 100));

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.setVisible(false);

		int colNum = myWholeSheet.get(0).size();
		
		String[][] myArray = new String[myWholeSheet.toArray().length][colNum];
	
		for (int x = 0; x < colNum; x++) {
			String names = "";
			names = myWholeSheet.get(0).get(x);
			myArray[0][x] = names;
		}
		for (int i = 1; i < myWholeSheet.toArray().length; i++) {
			ArrayList<String> row = new ArrayList<>();
			row = myWholeSheet.get(i);
			System.out.println(row);
			myArray[i - 1] = row.toArray(new String[colNum]);
		}

		JFrame jf = new JFrame();
		JTable table = new JTable(new DefaultTableModel(myArray, myWholeSheet.get(0).toArray()));
		table.setBounds(20, 30, 80, 100);
		JScrollPane scrollPane = new JScrollPane(table);
		jf.add(scrollPane);
		jf.setSize(1080, 720);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		table.setAutoCreateRowSorter(true);
		jf.setVisible(true);
		jf.setTitle("table");

	}

	
}
