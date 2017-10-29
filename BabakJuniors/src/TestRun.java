import java.util.ArrayList;

public class TestRun {
	/**
	 * TestRun
	 *
	 * @Authors: Ahmed Khattab, Arsalan Sadiq, Jeff Tudor , Hunho Ha
	 * @Purpose: A class which allows to run the test cases
	 *
	 * @field variables
	 *
	 * 
	 * @methods main: all the test cases are being run in
	 *
	 */
	public TestRun() {

	}

	/**
	 * printTestInfo will print the training examples for this test
	 * 
	 * @param houses
	 *            list of training examples to be used
	 * @param n
	 *            the test number
	 */
	public static void printTestInfo(ArrayList<House> houses, int n) {
		int c = 0;
		System.out.println("Test " + n);
		System.out.println("");
		System.out.println("");
		for (House h : houses) {
			System.out.println("Training example " + c + ": Coordinate = (" + h.getCorX() + "," + h.getCorY()
					+ "), Age = " + h.getAgeString() + ", SqrFt = " + "" + h.getSqrFt() + ", Price = " + h.getPrice());
			c++;
		}
	}

	/**
	 * runTest method will find the price of the new house given the k neighbors
	 * 
	 * @param r
	 *            the instance of the running KNN
	 * @param k
	 *            the number of K neighbors
	 */
	public static void runTest(KNN r, int k) {
		// reset list of nearest neighbors
		r.resetNN();
		// find nearest neighbors
		r.findKNN(k, r.getNewHouse(), r.getHouses());
		// calculate price based off of nearest neighbors
		r.setNewHousePrice();
		System.out.println("The testing example is: K = " + k + ", Coordinate = (" + r.getNewHouse().getCorX() + ","
				+ r.getNewHouse().getCorY() + "), Age = " + r.getNewHouse().getAgeString() + ", Sqrft = "
				+ r.getNewHouse().getSqrFt());
		System.out.println("The price of the testing example is " + r.getNewHouse().getPrice());
	}

	/**
	 * 
	 * this method prints the actual, predicted and the error for the price
	 * calculated
	 * 
	 * @param An
	 *            arraylist of type house
	 */
	public static void calculateError(ArrayList<House> houses) {
		// KNN Error = new KNN();
		// ArrayList<float> list = new ArrayList<float>() ;
		KNN Error = new KNN();
		System.out.println();
		for (int j = 0; j < houses.size(); j++) {
			float predict = 0;
			float actual = 0;
			for (int i = 0; i < houses.size(); i++) {
				if (i == j) {
					Error.setNewHouse(houses.get(i).getCorX(), houses.get(i).getCorY(), houses.get(i).getAgeString(),
							houses.get(i).getSqrFt()); // putting each house as

					actual = houses.get(i).getPrice();
				} else {
					Error.addHouse(houses.get(i).getCorX(), houses.get(i).getCorY(), houses.get(i).getAgeString(),
							houses.get(i).getSqrFt(), houses.get(i).getPrice());
				}
			}
			Error.resetNN();
			// find nearest neighbors
			Error.findKNN(2, Error.getNewHouse(), Error.getHouses());
			// calculate price based off of nearest neighbors
			Error.setNewHousePrice();
			predict = Error.getNewHouse().getPrice();
			float errnum = ((Math.abs(actual - predict) / actual) * 100);
			System.out.println("Actual price for" + (j + 1) + " House is " + "$" + actual);
			System.out.println("Predicted price for" + (j + 1) + " House is " + "$" + predict);

			System.out.println("Error Calculation = " + String.format("%.2f", errnum) + "%");
		}
	}

	/**
	 * Main method where all the testing occurs
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		KNN running = new KNN();
		// populate the list of training examples
		running.addHouse(12, 25, "New", 1200, 500000);
		running.addHouse(10, 50, "Old", 1000, 300000);
		running.addHouse(30, 100, "New", 800, 400000);
		running.setNewHouse(15, 20, "New", 1000);

		// run test 1 using known houses and k=1
		printTestInfo(running.getHouses(), 1);
		runTest(running, 1);

		// run test 2 using known houses and k=2

		printTestInfo(running.getHouses(), 2);
		runTest(running, 2);

		// run test 3 using known houses and k=3
		printTestInfo(running.getHouses(), 3);
		runTest(running, 3);

		calculateError(running.getHouses());
	}
}
