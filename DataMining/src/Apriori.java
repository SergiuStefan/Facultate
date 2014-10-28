import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Apriori {

	@SuppressWarnings({ "resource" })
	void ReadFile() throws IOException {
		String csvFile = "D:/Facultate/eclipse/DataMining/test_59_2.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFile));

		List<String[]> content = csvReader.readAll();

		String[] header = content.get(0);
		int[] items = new int[header.length - 1];

		for (int i = 0; i < items.length; i++) {
			items[i] = 0;
		}
		for (int i = 1; i < content.size(); i++) {
			String[] linie = content.get(i); // selecteaza fiecare linie in
												// parte
			// System.out.println(linie.toString());
			for (int j = 1; j < linie.length; j++) {
				if (header[j].equals(linie[j])) {
					items[j - 1]++;
				}
			}
		}

		int prag = 25;
		for (int i = 0; i < items.length; i++) {
			if (items[i] > prag) {
				System.out.print("P" + (i + 1) + " = " + items[i] + ", ");
			} else {
				System.out.print("-, ");
			}
		}
		

		// System.out.println("Done");
	}

}
