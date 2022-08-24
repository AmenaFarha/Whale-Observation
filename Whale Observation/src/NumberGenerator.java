public class NumberGenerator {

	private int randomNumber;

	/**
	 * Constructor for objects of class NumberGenerator
	 */

	public NumberGenerator() {

	}

	public NumberGenerator(int minLimit, int maxLimit) {
		getNumberGenerator(minLimit, maxLimit);
	}

	public int getNumberGenerator(int minLimit, int maxLimit) {
		randomNumber = (int) (Math.random() * (maxLimit - minLimit + 1) + minLimit);
		return randomNumber;
	}

}