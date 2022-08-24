public class Whale {

	String whaleDirection;
	String whaleHealth;
	String whaleSpecies;
	int accompanyCalf;

	/**
	 * Constructor for objects of class Whale
	 */

	public Whale() {
		whaleDirection = "";
		whaleHealth = "";
		whaleSpecies = "";
		accompanyCalf = 0;
	}

	/**
	 * Parameterised Constructor for objects of class Whale
	 */

	public Whale(String direction, String health, String species, int accompanyCalves) {
		this.whaleDirection = direction;
		this.whaleHealth = health;
		this.whaleSpecies = species;
		this.accompanyCalf = accompanyCalves;
	}

	public int getAccompanyCalfNumber() {
		return accompanyCalf;
	}

	public String getDirection() {
		return whaleDirection;
	}

	public String getHealth() {
		return whaleHealth;
	}

	public String getSpecies() {
		return whaleSpecies;
	}

	public void setAccompanyCalfNumber(int calfNumber) {
		accompanyCalf = calfNumber;
	}

	public void setDirection(String direction) {
		whaleDirection = direction;
	}

	public void setHealth(String health) {
		whaleHealth = health;
	}

	public void setSpecies(String species) {
		whaleSpecies = species;
	}

	public void whaleInformation() {
		System.out.println("Species: " + getSpecies());
		System.out.println("Health: " + getHealth());
		System.out.println("Direction: " + getDirection());
		System.out.println("Number of accompany calf: " + getAccompanyCalfNumber());
		System.out.println("");
	}

}