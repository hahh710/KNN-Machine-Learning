import java.util.ArrayList;
import java.util.List;

/**
 * an instance of KNN belongs to each instance of testing example
 *
 * @Authors: Jeff Tudor
 * @Purpose: Determine the nearest neighbors of a given testing example, given a certain K
 *
 * @field variables
 * - nearestNeighbors ArrayList<TrainingExamples>: represents the list of nearest neighbors
 * - k int: represents the number of nearest neighbors
 * - testEx Testing Example: represents the reference to the owner of this instance
 * 
 * @methods 
 *+getNN: returns the list of NN --> resets list of NN, then calls findKNN
 *+findKNN: the algorithm which determines which are the nearest neighbors, using distance from owner (testing example)
 *+setK: set the value of K, when k changes, NN will be called and automattically update KNN
 *
 *
 */
public class KNN {
	private ArrayList<TrainingExample> nearestNeighbors;
	private Distance distances;
	private int k;
	private TestingExample testEx;
	public KNN(int k, TestingExample testEx) {
		this.k=k;
		this.testEx=testEx;
		nearestNeighbors = new ArrayList<TrainingExample>();
	}
	/**getNN() will return list of NN
	 * 
	 * @return list of Nearest Neighbors
	 */
	public ArrayList<TrainingExample> getNN() {
		return nearestNeighbors;
	}
	public void determineNearestNeighbors(int effK, ArrayList<TrainingExample> potentialNN) {
		nearestNeighbors.clear();
		findKNN(effK, potentialNN);
	}

	/**
	 * findKNN
	 * 
	 * @param 
	 * effK: the effecting k value as k will change with recursive calls
	 * potentialNN: the list of potential training examples to be added as nearest neighbors
	 * 
	 *   Recursively find the training example with the smallest distance to the testing example
	 *   Calls itself recursively k times
	 * 
	 */
	public void findKNN(int effK, ArrayList<TrainingExample> potentialNN) {
		TrainingExample nearestNeighbor = new TrainingExample();
		if (effK > 0) { // if K>0 then must find nearestNeighbor and append to list
						// of NN
			float distance = -1;
			float smallestDistance = -1;
			for (TrainingExample t : potentialNN) {
				distance = testEx.getDistances().findDistance(testEx, t);
				if (smallestDistance == -1) {// first house in list will initially be NN
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
			newPotentialNN.remove(nearestNeighbor);// remove the determined nearestNeighbor
			findKNN(effK - 1, newPotentialNN);// Recursively call until k neighbors have been determined
		}

		// K nearest neighbors have been determined
	}
	/**
	 * 
	 * @param n: represents new K value
	 * @return return updated list of NN
	 * Changing the k value will automatically update the nearest neighbors 
	 */
	public void setK(int n) {
		k=n;
	}
	public int getK() {
		return k;
	}
}