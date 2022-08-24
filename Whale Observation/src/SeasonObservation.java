import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SeasonObservation {

	ArrayList<Integer> observationList;

	/**
	 * Constructor for objects of class SeasonObservation
	 */
	public SeasonObservation() {

	}

	public ArrayList getList() {
		return observationList;
	}

	public void readFile() {
		observationList = new ArrayList<Integer>();
		try {
			FileReader inputFile = new FileReader("seasonObservations.txt");
			try {
				Scanner input = new Scanner(inputFile);
				while (input.hasNextLine()) {
					String[] whaleNumber = input.nextLine().split(",");
					for (int i = 0; i < whaleNumber.length; i++) {
						observationList.add(Integer.parseInt(whaleNumber[i]));

					}
				}
			} finally {
				inputFile.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println(" File not found");
		} catch (IOException e) {
			System.out.println("Unexpected I/O error occured");
		}
	}

	public void setList(ArrayList list) {
		this.observationList = list;
	}
}
