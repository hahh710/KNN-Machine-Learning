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
 *
 *the KNN class will be called from a testing example to find its nearest neighbors
 *
 *finds neighbors of a test example from a list of training example
 */
public class KNN {
	private ArrayList<TrainingExample> nearestNeighbors;
	private int k;
	private TestingExample testEx;
	public KNN(int k, TestingExample testEx) {
		this.k=k;
		this.testEx=testEx;
		nearestNeighbors = new ArrayList<TrainingExample>();
	}
	public List<TrainingExample> getNN() {
		nearestNeighbors.clear();
		findKNN(k, testEx, testEx.getExampleManager().getTrainingExamples());
		return nearestNeighbors;
	}
	public void setNearestNeighbors(List<House> nearestNeighbors) {
		this.nearestNeighbors = nearestNeighbors;
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
	public void findKNN(int k, TestingExample testEx, ArrayList<TrainingExample> potentialNN) {
		TrainingExample nearestNeighbor = new TrainingExample();
		if (k > 0) { // if K>0 then must find nearestNeighbor and append to list
						// of NN
			float distance = -1;
			float smallestDistance = -1;
			for (TrainingExample t : potentialNN) {
				distance = testEx.getDistances().findDistance(t, testEx);
				if (smallestDistance == -1) {// first house in list will
												// initially be NN
					smallestDistance = distance;
					nearestNeighbor = t;
				}
				if (smallestDistance > distance) {// new smallest distance
					smallestDistance = distance;
					nearestNeighbor = t;
				}
			}
			nearestNeighbors.add(nearestNeighbor);// append NN
			ArrayList<TrainingExample> newPotentialNN = new ArrayList<TrainingExample>();
			for (TrainingExample t : potentialNN) {
				newPotentialNN.add(t);
			}
			newPotentialNN.remove(nearestNeighbor);// remove the determined
													// nearestNeighbor
			findKNN(k - 1, testEx, newPotentialNN);// Recursively call until k
														// neighbors have been
														// determined
		}

		// K nearest neighbors have been determined
	}
}