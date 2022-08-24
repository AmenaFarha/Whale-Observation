public class Location {

	String desirableLocation;
	String location;
	String migalooLocation;

	/**
	 * Constructor for objects of class Location
	 */

	public Location() {

	}

	/**
	 * Parameterised Constructor for objects of class Location
	 */

	public Location(String loaction) {
		location = "";
	}

	public String getDesirableLocation() {
		return desirableLocation;
	}

	public String getLocation() {
		return location;
	}

	public String getMigalooLocation() {
		return migalooLocation;
	}

	public void migalooSightedLocation(int migaloo) {
		if (migaloo == 1) {
			System.out.println("Migaloo whale has been sighted at oberservation point " + getMigalooLocation() + ".");
		}

		else {
			System.out.println("No migaloo whale has been sighted at any oberservation point.");
		}
	}

	public void showDesirableLocation() {
		System.out.println("" + desirableLocation + " is the most desirable Location according to Whale "
				+ "Watching Location Desirability factor (WWLD).");
	}

	public void setDesirableLocation(int wwld1, int wwld2, int wwld3, int wwld4) {
		if ((wwld1 > wwld2) && (wwld1 > wwld3) && (wwld1 > wwld4)) {
			desirableLocation = "Eden";
		}

		else if ((wwld2 > wwld1) && (wwld2 > wwld3) && (wwld2 > wwld4)) {
			desirableLocation = "Jervis Bay";
		}

		else if ((wwld3 > wwld1) && (wwld3 > wwld2) && (wwld3 > wwld4)) {
			desirableLocation = "Byron Bay";
		} else if ((wwld4 > wwld1) && (wwld4 > wwld2) && (wwld4 > wwld3)) {
			desirableLocation = "Hervey Bay";
		}
	}

	public void setLocation(int locationNumber) {
		switch (locationNumber) {
		case 1:
			location = "Eden";
			break;
		case 2:
			location = "Jervis Bay";
			break;
		case 3:
			location = "Byron Bay";
			break;
		case 4:
			location = "Hervey Bay";
			break;
		default:
		}
	}

	public void setMigalooLocation(String mLocation) {
		this.migalooLocation = mLocation;
	}
}
