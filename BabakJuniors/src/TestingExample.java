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
	private Example exampleManager;

	public TestingExample( Example eM) {
		super(eM);
		exampleManager = eM;
		distances = new Distance(this);
		knn = null;
	}
	/**
	 * Constructor to create copy of training example
	 * @param testEx
	 */
	public TestingExample(TrainingExample tEx, Example eM) {
		super(eM);
		setFeatures(tEx.getAllFeatures());
		exampleManager = eM;
		distances = new Distance(this);
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
	 * 
	 * @return knn
	 */
	public KNN getKNN() {
		return knn;
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
	 * PredictFeature
	 * 
	 * @param f
	 * 
	 *            sets the feature value passed in the parameter as the average
	 *            of the list of features in the example class.
	 */
	public void predictFeature(String f, int valueType, int k) {
		int count = 0;
		distances.updateDistances();
		knn = new KNN(k, this);
		knn.determineNearestNeighbors(k, exampleManager.getTrainingExamplesModel());
		knn.getNN();
		// Subjective f
		
		if (valueType==1) {
			int position = 0;
			for (TrainingExample t : knn.getNN()) {
				position += t.getAllFeatures().get(f).getRank();
				count++;
			}
			position = position / count;
			//need to get ranklist from this feature type
			//getAllFeatures().replace(f, new Feature(exampleManager.getRankingList(f).getValueAtRank(position)));
			addFeature(f, new Feature(exampleManager.getSubjectiveRanking(f).getStringValueAtRank(position)));

		}
		else if (valueType==2) {
			float sum = 0;
			for (TrainingExample t : knn.getNN()) {
				sum += t.getAllFeatures().get(f).getNumValue();
				count++;
			}
			sum = sum / count;
			System.out.println("test");
			//getAllFeatures().replace(f, new Feature(sum));
			addFeature(f, new Feature(sum));
		}
		else if (valueType==3) {
			Integer xSum = 0;
			Integer ySum = 0;
			for (TrainingExample t : knn.getNN()) {
				xSum += t.getAllFeatures().get(f).getCorX();
				ySum += t.getAllFeatures().get(f).getCorY();
				count++;
			}
			xSum = xSum / count;
			ySum = ySum / count;
			addFeature(f, new Feature(xSum, ySum));
			//getAllFeatures().replace(f, new Feature(xSum, ySum));
		
		}

	}
}