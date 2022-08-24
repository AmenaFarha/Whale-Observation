import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
public class WhaleWatching {
	
	private int accompanyCalf;
	private int blue;
	private int blueCalf;
	private int calfNuumber;
	private ArrayList<Integer> dayObservationList = new ArrayList<>();
	private String direction;
	private NumberGenerator generatedNumber = new NumberGenerator();  //create instance of NumberGenerator class
	private String health;
	private int humbpack;
	private int humbpackCalf;
	private int injuredBlue;
	private int injuredHumbpacke;
	private int injuredMinke;
	private int injuredOrca;
	private int injuredSouthernRight;
	private ArrayList<Integer> list = new ArrayList<>();
	private Location location = new Location(); //create instance of Location class
	private int migaloo;
	private String migalooDirection;
	private String migalooHealth;
	private int migalooWhale = 0;
	private int minke;
	private int minkeCalf;
	private SeasonObservation number = new SeasonObservation(); //create instance of SeasonObservation class
	private Observer observer = new Observer(); //create instance of Observer class
	private int orca;
	private int orcaCalf;
	private int southernRightCalf;
	private int southernRight;
	private int speciesNumber;
	private String species;
	int[] updatedData = new int[100];
	private Whale whale = new Whale();  //create instance of Whale class
	
	/**
     * Constructor for objects of class Whale
     */
	public WhaleWatching() {
		migaloo = 0;
		injuredHumbpacke = 0;
		injuredMinke = 0;
		injuredSouthernRight = 0;
		injuredBlue = 0;
		injuredOrca = 0;
	}

	public int calculateDesirabilityFactor(int index) {
		int totalAdults = 0;
		int totalCalves = 0;
		int totalRareWhales = 0;
		int totalMigaloo = 0;

		if (index % 2 == 0) {
			for (int i = index; i <= index + 10; i++) {
				if (i % 2 == 0 && i < index + 10) {
					totalAdults = totalAdults + updatedData[i];
				}

				if (i % 2 == 1) {
					totalCalves = totalCalves + updatedData[i];
				}

				if (i >= index + 6 && i <= index + 9) {
					totalRareWhales = totalRareWhales + updatedData[i];
				}

				if (i == index + 10) {
					totalMigaloo = totalMigaloo + updatedData[i];
				}
			}
		} else {
			for (int i = index; i <= index + 10; i++) {
				if (i % 2 == 1 && i < index + 10) {
					totalAdults = totalAdults + updatedData[i];
				}

				if (i % 2 == 0) {
					totalCalves = totalCalves + updatedData[i];
				}

				if (i >= index + 6 && i <= index + 9) {
					totalRareWhales = totalRareWhales + updatedData[i];
				}

				if (i == index + 10) {
					totalMigaloo = totalMigaloo + updatedData[i];
				}
			}
		}

		int wwld = totalAdults + (2 * totalCalves) + (4 * totalRareWhales) + (10 * totalMigaloo);
		return wwld;
	}

	public void checkAccompany() {
		if (direction == "N") {
			calfNuumber = 0;
		} else {
			calfNuumber = generatedNumber.getNumberGenerator(0, 1);
			}
	}

	public void checkDirection() {
		int selectDirection = generatedNumber.getNumberGenerator(1, 2);

		switch (selectDirection) {
		case 1:
			direction = "N";
			break;
		case 2:
			direction = "S";
			break;
		default:
		}
	}

	public void checkHealth() {
		int healthProbability = generatedNumber.getNumberGenerator(1, 100);

		if (healthProbability >= 1 && healthProbability <= 10) {
			health = "Injured";
			injuredSpecies(species);
		} else {
			health = "Healthy";
		}
	}

	public void checkObserverName(String name) {

		if ((name.trim().length() == 0) || (name == null)) {
			System.out.println("Name cannot be blank.");
			setObserverName();
		} else if (name.trim().length() > 8) {
			System.out.println("Name cannot contain more than 8 characters.");
			setObserverName();
		} else {
			observer.setObserverName(name);
			observer.message();
		}
	}

	public void checkSpecies() {
		int speciesProbability = generatedNumber.getNumberGenerator(1, 100);

		if (speciesProbability >= 1 && speciesProbability <= 50) {
			species = "Humbpack";
			speciesNumber = 1;
			humbpack++;
		} else if (speciesProbability >= 51 && speciesProbability <= 75) {
			species = "Minke";
			speciesNumber = 2;
			minke++;
		} else if (speciesProbability >= 76 && speciesProbability <= 95) {
			species = "Southern Right";
			speciesNumber = 3;
			southernRight++;
		} else if (speciesProbability >= 96 && speciesProbability <= 98) {
			species = "Blue";
			speciesNumber = 4;
			blue++;
		} else {
			species = "Orca";
			speciesNumber = 5;
			orca++;
		}
	}

	public void countCalf(int speciesNumber) {
		switch (speciesNumber) {
		case 1:
			humbpackCalf++;
			break;
		case 2:
			minkeCalf++;
			break;
		case 3:
			southernRightCalf++;
			break;
		case 4:
			blueCalf++;
			break;
		case 5:
			orcaCalf++;
			break;
		default:
		}
	}

	public void dayObservation() {
		int totalCalves = 0;
		int adultWhale = generatedNumber.getNumberGenerator(0, 9);
		if (adultWhale == 0) {
			System.out.println("No adult whale has been seen at this location today.");
		} else {
			System.out.println("" + adultWhale + " adult whale have been seen in this point today.");
			System.out.println("");
			System.out.println("Details of each adult whale sighted:");
			System.out.println("");
			for (int i = 1; i <= adultWhale; i++) {
				checkSpecies();
				whale.setSpecies(species);
				checkDirection();
				whale.setDirection(direction);
				checkAccompany();
				whale.setAccompanyCalfNumber(calfNuumber);
				checkHealth();
				whale.setHealth(health);
				if (species == "Humbpack") {
					isMigaloo();
				}
				if (direction == "S" && calfNuumber == 1) {
					countCalf(speciesNumber);
					totalCalves++;
				}
				whale.whaleInformation();
			}
			System.out.println("Total whale: " + (adultWhale + totalCalves));
			System.out.println("Total adult whale: " + adultWhale);
			System.out.println("Total calves: " + totalCalves);
		}
	}

	public void DayObservationFile() {
		try {
			FileWriter fw = new FileWriter("dayObservation.txt");

			for (int i = 0; i < 44; i++) {
				fw.write(dayObservationList.get(i) + ",");

				if (i == 10 || i == 21 || i == 32) {
					fw.write("\n");
				}
			}

			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Day Observation data stored successfully.");

	}

	public void display() {
		System.out.println("***********************************************");
		System.out.println("***** Hello! Welcome to Whale Observation *****");
		System.out.println("***********************************************");
		System.out.println();
	}

	public void injuredSpecies(String speciesName) {
		if (speciesName == "Humbpack") {
			injuredHumbpacke++;
		} else if (speciesName == "Minke") {
			injuredMinke++;
		}

		else if (speciesName == "Southern Right") {
			injuredSouthernRight++;
		}

		else if (speciesName == "Southern Right") {
			injuredSouthernRight++;
		} else if (speciesName == "Blue") {
			injuredBlue++;
		} else {
			injuredOrca++;
		}

	}

	private static boolean isAlphabet(String str) {
		if (str.matches("[a-zA-Z]+"))
			return true;
		else
			return false;
	}

	public void isMigaloo() {
		if (migalooWhale == 0) {
			int migalooChance = generatedNumber.getNumberGenerator(1, 100);

			if (migalooChance == 10) // as 1-100 each has 1% chance so, set 10 as a threshold values
			{
				migalooWhale = 1;
				migaloo++;
				String migalooLocation = location.getLocation();
				location.setMigalooLocation(migalooLocation);
				migalooHealth = health;
				migalooDirection = direction;
			}
		}
	}

	public void locationDesirability() {
		int wwld1 = calculateDesirabilityFactor(0);
		int wwld2 = calculateDesirabilityFactor(11);
		int wwld3 = calculateDesirabilityFactor(22);
		int wwld4 = calculateDesirabilityFactor(33);
		System.out.println("WWLD for Eden : " + wwld1);
		System.out.println("WWLD for Jervis Bay : " + wwld2);
		System.out.println("WWLD for Byron Bay : " + wwld3);
		System.out.println("WWLD for Hervey Bay : " + wwld4);
		location.setDesirableLocation(wwld1, wwld2, wwld3, wwld4);
		location.showDesirableLocation();
	}

	public static void main(String[] args) {
		WhaleWatching whaleWatching = new WhaleWatching();
		whaleWatching.start();
	}

	public void observationPointDisplay(int locationPoint) {
		location.setLocation(locationPoint);
		System.out.println("");
		System.out.println("***********************************************");
		System.out.println("       Day Oberservation for " + location.getLocation() + "     ");
		System.out.println("***********************************************");
		System.out.println();

	}

	public void observeEachLocation() {
		for (int i = 1; i <= 4; i++) {
			humbpack = 0;
			minke = 0;
			southernRight = 0;
			blue = 0;
			orca = 0;
			humbpackCalf = 0;
			minkeCalf = 0;
			southernRightCalf = 0;
			blueCalf = 0;
			orcaCalf = 0;
			migaloo = 0;
			observationPointDisplay(i);
			setObserverName();
			dayObservation();
			reviewObservation();
			if (migalooWhale == 1 && migaloo == 1) {
				System.out.println("A migaloo has been sighted at this location.");
				System.out.println("Migaloo Health: " + migalooHealth);
				System.out.println("Migaloo Direction: " + migalooDirection);
			}
		}
	}

	public void reviewObservation() {
		dayObservationList.add(humbpack);
		dayObservationList.add(humbpackCalf);
		dayObservationList.add(minke);
		dayObservationList.add(minkeCalf);
		dayObservationList.add(southernRight);
		dayObservationList.add(southernRightCalf);
		dayObservationList.add(blue);
		dayObservationList.add(blueCalf);
		dayObservationList.add(orca);
		dayObservationList.add(orcaCalf);
		dayObservationList.add(migaloo);
	}

	public void setObserverName() {
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String name = console.nextLine();
		isAlphabet(name);
		if (isAlphabet(name)) {
			checkObserverName(name);
		} else {
			System.out.println("Invalid!! Name can only have alphabets A-Z/a-z");
			setObserverName();
		}
	}

	public void showObservation() {
		int totalHumbpack = 0;
		int totalMinke = 0;
		int totalSouthernRight = 0;
		int totalBlue = 0;
		int totalOrca = 0;
		int totalHumbpackCalf = 0;
		int totalMinkeCalf = 0;
		int totalSouthernRightCalf = 0;
		int totalBlueCalf = 0;
		int totalOrcaCalf = 0;

		for (int i = 0; i < 44; i = i + 11) {
			totalHumbpack = totalHumbpack + dayObservationList.get(i);
			totalHumbpackCalf = totalHumbpackCalf + dayObservationList.get(i + 1);

			totalMinke = totalMinke + dayObservationList.get(i + 2);
			totalMinkeCalf = totalMinkeCalf + dayObservationList.get(i + 3);

			totalSouthernRight = totalSouthernRight + dayObservationList.get(i + 4);
			totalSouthernRightCalf = totalSouthernRightCalf + dayObservationList.get(i + 5);

			totalBlue = totalBlue + dayObservationList.get(i + 6);
			totalBlueCalf = totalBlueCalf + dayObservationList.get(i + 7);

			totalOrca = totalOrca + dayObservationList.get(i + 8);
			totalOrcaCalf = totalOrcaCalf + dayObservationList.get(i + 9);
		}

		System.out.println("*******************************************************************");
		System.out.println("*         Day Obervation Summary For Each Type of Whale           *");
		System.out.println("*******************************************************************");
		System.out.println("");
		System.out.println("=================  Species :  Humpback  ==========================");
		System.out.println("");
		System.out.println("Total number observed over the four locations : " + (totalHumbpack + totalHumbpackCalf));
		System.out.println("Total number of adultes whales : " + totalHumbpackCalf);
		System.out.println("Total number of calves : " + totalHumbpackCalf);
		System.out.println("Total number of injured whales: " + injuredHumbpacke);
		location.migalooSightedLocation(migalooWhale);
		System.out.println("");

		System.out.println("==================  Species :  Minke  ============================");
		System.out.println("");
		System.out.println("Total number observed over the four locations : " + (totalMinke + totalMinkeCalf));
		System.out.println("Total number  of adult whales : : " + totalMinke);
		System.out.println("Total number of calves : " + totalMinkeCalf);
		System.out.println("Total number of injured whales: " + injuredMinke);
		System.out.println("");

		System.out.println("==============  Species :  Southern Right  =======================");
		System.out.println("");
		System.out.println(
				"Total number observed over the four locations : " + (totalSouthernRight + totalSouthernRightCalf));
		System.out.println("Total number  of adult whales : " + totalSouthernRight);
		System.out.println("Total number Of calves : " + totalSouthernRightCalf);
		System.out.println("Total number of injured whales: " + injuredSouthernRight);
		System.out.println("");

		System.out.println("====================  Species : Blue  ============================");
		System.out.println("");
		System.out.println("Total number observed over the four locations : " + (totalBlue + totalBlueCalf));
		System.out.println("Total  number  of adult whales : " + totalBlue);
		System.out.println("Total number of calves : " + totalBlueCalf);
		System.out.println("Total number of injured whales: " + injuredBlue);
		System.out.println("");

		System.out.println("====================  Species : Orca  ============================");
		System.out.println("");
		System.out.println("Total number observed over the four locations : " + (totalOrca + totalOrcaCalf);
		System.out.println("Total  number  of adult whales : " + totalOrca);
		System.out.println("Total number Of calves : " + totalOrcaCalf);
		System.out.println("Total number of injured whales: " + injuredOrca);
		System.out.println("");
	}

	public void start() {
		display();
		observeEachLocation();
		DayObservationFile();
		updatedObsercationList();
		System.out.println("");
		showObservation();
		updateFile();
		locationDesirability();

	}

	public void updatedObsercationList()

	{
		number.readFile();
		list = number.getList();

		for (int i = 0; i < 44; i++) {
			int w1 = dayObservationList.get(i);
			int w2 = list.get(i);
			updatedData[i] = w1 + w2;
		}

	}

	public void updateFile() {
		try {
			FileWriter fw = new FileWriter("seasonObservationsUpdated.txt");

			for (int i = 0; i < 44; i++) {
				fw.write(updatedData[i] + ",");

				if (i == 10 || i == 21 || i == 32) {
					fw.write("\n");
				}
			}

			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Updated Season Observation data successfully.");
	}
}
