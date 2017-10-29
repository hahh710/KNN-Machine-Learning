import java.util.ArrayList;
import java.util.List;

/**
 * KNN
 *
 * @Authors: Jeff Tudor
 * @Purpose: Determine the price of a house given its house attributes compared
 *           to similar houses
 *
 * @field variables houses: A collection of houses with known attributes and
 *        price nearestNeighbors: A collection of houses used to determine the
 *        price of a certain house
 * 
 * @methods main: findKNN: findDistance: findPrice:
 *
 */
public class KNN {
	private List<House> houses;
	private List<House> nearestNeighbors;

	public List<House> getNearestNeighbors() {
		return nearestNeighbors;
	}

	public void setNearestNeighbors(List<House> nearestNeighbors) {
		this.nearestNeighbors = nearestNeighbors;
	}

	private House newHouse;

	public KNN() {
		houses = new ArrayList<House>();
		nearestNeighbors = new ArrayList<House>();
		newHouse = null;
	}

	/**
	 * findKNN
	 * 
	 * @param -an
	 *            integer k representing the number of neighbors looked at to
	 *            determine price of new house -an object of type House, called
	 *            newHouse which will be compared against other houses
	 *
	 *            1. Reset list of nearestNeighbors right before function
	 *            call*smelly needs fixing 2. Iterate through the collection of
	 *            houses and append the one with shortest distance to the new
	 *            house 3. Repeat the process on the same collection less the
	 *            appended house 4. Repeat k times
	 * 
	 */
	public void findKNN(int k, House newHouse, ArrayList<House> potentialNN) {
		House nearestNeighbor = new House();
		if (k > 0) { // if K>0 then must find nearestNeighbor and append to list
						// of NN
			float distance = -1;
			float smallestDistance = -1;
			for (House h : potentialNN) {
				distance = findDistance(h, newHouse);
				if (smallestDistance == -1) {// first house in list will
												// initially be NN
					smallestDistance = distance;
					nearestNeighbor = h;
				}
				if (smallestDistance > distance) {// new smallest distance
					smallestDistance = distance;
					nearestNeighbor = h;
				}
			}
			nearestNeighbors.add(nearestNeighbor);// append NN
			ArrayList<House> newPotentialNN = new ArrayList<House>();// smelllllllly
			for (House h : potentialNN) {
				newPotentialNN.add(h);
			}
			newPotentialNN.remove(nearestNeighbor);// remove the determined
													// nearestNeighbor
			findKNN(k - 1, newHouse, newPotentialNN);// Recursively call until k
														// neighbors have been
														// determined
		}

		// K nearest neighbors have been determined
	}

	/**
	 * findPrice(List<House> NN)
	 * 
	 * @Parameters -list of houses -> nearest neighbors determined by findKNN
	 *             method
	 *
	 * @returns -returns price of new house -> simply calculated by averaging
	 *          nearest neighbors for the purposes of milestone 1
	 *
	 */
	public int findPrice() {
		float sum = 0;
		int count = 0;
		for (House h : nearestNeighbors) {
			sum += h.getPrice();
			count++;
		}
		return (int) sum / count;
	}

	/**
	 * findDistance (House h1, House h2)
	 * 
	 * @param -two
	 *            houses that are being compared
	 * @return -return a float representing the distance between the two houses
	 * 
	 *         Determine distance between two houses //index 0 of arraylist has
	 *         coordinates //index 1, Age //index 2, sqrFt //index 3, price
	 */
	public float findDistance(House h1, House h2) {
		return findCoordinateDistance(h1, h2) + findAgeDistance(h1, h2) + findSqrFtDistance(h1, h2);
	}

	/**
	 * findCoordinateDistance(House h1, House h2)
	 * 
	 * @param -two
	 *            houses that are being compared
	 * @return -returns a float representing the euclidean distance between the
	 *         two houses which are being compared
	 * 
	 *         Determine the euclidean distance between two houses using
	 *         dist(h1(x, y), h2(a, b)) = sqrt((x - a)� + (y - b)�)
	 */
	public float findCoordinateDistance(House h1, House h2) {
		return Math.abs(
				(float) Math.sqrt(Math.pow(h1.getCorX() - h2.getCorX(), 2) + Math.pow(h1.getCorY() - h2.getCorY(), 2)));
	}

	/**
	 * Determines the age distance
	 * 
	 * @param house
	 *            h1 and house h2
	 * @returns the age distance between the two houses
	 */
	public float findAgeDistance(House h1, House h2) {
		return Math.abs(h1.getAge() - h2.getAge());
	}

	/**
	 * Determines the sqrft distance
	 * 
	 * @param house
	 *            h1 and house h2
	 * @returns the sqrft distance between the two houses
	 */
	public float findSqrFtDistance(House h1, House h2) {
		return Math.abs(h1.getSqrFt() - h2.getSqrFt());
	}

	/**
	 * Takes in all the house specifications
	 * 
	 * @param takes
	 *            in the coordinates of x and y aswell as the age, sqrft and the
	 *            price of the house
	 */
	public void addHouse(int x, int y, String a, int sf, float p) {
		houses.add(new House(x, y, a, sf, p));
	}

	/**
	 * Sets the house specifications
	 * 
	 * @param takes
	 *            in the coordinates of x and y aswell as the age, sqrft and the
	 *            price of the house
	 */
	public void setNewHouse(int x, int y, String a, int sf) {
		newHouse = new House(x, y, a, sf);
	}

	/**
	 * Clears the nearest neighbours.
	 */
	public void resetNN() {
		nearestNeighbors.clear();
	}

	/**
	 * Void method that sets the new house price
	 */
	public void setNewHousePrice() {
		newHouse.setPrice(findPrice());
	}

	/**
	 * A getter for houses
	 * 
	 * @return an arraylist of type house which returns the current house
	 */
	public ArrayList<House> getHouses() {
		return (ArrayList<House>) houses;
	}

	/**
	 * A getter for new houses
	 * 
	 * @return type of house the new house added.
	 */
	public House getNewHouse() {
		return newHouse;
	}

}