public class Observer {

	String observerName;

	/**
	 * Constructor for objects of class Observer
	 */

	public Observer() {

	}

	/**
	 * Parameterised Constructor for objects of class Observer
	 */

	public Observer(String name) {

	}

	public String getObserverName() {
		return observerName;
	}

	public void message() {
		System.out.println("Hi " + observerName + "! Lets start the simulation for the day.");
		System.out.println("");
	}

	public void setObserverName(String name) {
		this.observerName = name;
	}

}
