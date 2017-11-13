/**
 * 
 * @author Arsalan Sadiq
 * @Purpose: inherits all the features from the training example and utilizes
 *           the the distance class to predict a certain feature compared to
 *           Training Example
 *
 * @field variables - distance Distance: an instance of distance class to update
 *        the distances - feature Feature: an instance of feature class to use
 *        it to add it to the testing example - knn KNN: an instance of KNN
 *        class to use it to add it to the testing example - k int : put the k
 *        value into the testing example withing the KNN class - exampleManager
 *        Example: instance of Example to get the list of the training example
 *        methods and used for ranking
 * 
 * @methods +getDistances: returns the distances +getExample: returns the
 *          exampleManager getK: returns the k value setK: changes the k value
 *          predictFeature: Feature :predicts the feature depending on the type
 *          of the feature and changes the feature in the list of testing
 *          example
 */
public class TestingExample extends TrainingExample {

	private Distance distances;
	private KNN knn;
	private int k;
	private Example exampleManager;

	public TestingExample(int k, Example eM) {
		this.setK(k);
		exampleManager = eM;
		distances = new Distance(this);
		knn = new KNN(k, this);
	}

	/**
	 * getDistances
	 * 
	 * @return distances
	 */
	public Distance getDistances() {
		return distances;
	}

	/**
	 * getExample
	 * 
	 * @return exampleManager
	 */
	public Example getExample() {
		return exampleManager;
	}

	/**
	 * getK
	 * 
	 * @return k
	 */
	public int getK() {
		return k;
	}

	/**
	 * setK
	 * 
	 * @param k
	 *            set the k value in the knn instance
	 */
	public void setK(int k) {
		// this.k = k;
		knn.setK(k);
	}

	/**
	 * PredictFeature
	 * 
	 * @param f
	 * 
	 *            sets the feature value passed in the parameter as the average
	 *            of the list of features in the example class.
	 */
	public void PredictFeature(Feature f) {
		String fName = f.getFName();
		int count = 0;
		distances.updateDistances();
		knn.getNN();
		exampleManager.getTrainingExamples();
		// Subjective f
		if (exampleManager.checkSubjective(f)) {
			int position = 0;
			for (TrainingExample t : knn.getNN()) {
				position += t.getAllFeatures().get(fName).getRank();
				count++;
			}
			position = position / count;
			f.setStringValue(f.getRankList().getValueAtRank(position));
		}
		if (exampleManager.checkAbsolute(f)) {
			int sum = 0;
			for (TrainingExample t : knn.getNN()) {
				sum += t.getAllFeatures().get(fName).getNumValue();
				count++;
			}
			sum = sum / count;
			f.setNumValue((float) sum);
		}
		if (exampleManager.checkEuclidean(f)) {
			int xSum = 0;
			int ySum = 0;
			for (TrainingExample t : knn.getNN()) {
				xSum += t.getAllFeatures().get(fName).getCorX();
				ySum += t.getAllFeatures().get(fName).getCorY();
				count++;
			}
			xSum = xSum / count;
			ySum = ySum / count;

			f.setCorX(xSum);
			f.setCorY(ySum);
		}

	}

}