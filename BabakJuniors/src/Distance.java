import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**Class Distance
 * 
 * Each testing example has an instance of Distance
 * 
 * Class Distance's purpose is to maintain a dictionary which contains a key for every feature type and a list of distances between
 * the testing example which an instance of this class would belong to and each training example 
 * number of rows= number of features, number of columns = number of training examples
 * 
 * @author JeffA
 * @Instance Variables
 *-distances: Map <String, List <Float> strings represent feature names, list is a collection of distances between test and training examples 
 *-normDist: Map <String, List <Float> represents a copy of distances except with normalized values
 *-lookUpTable: Map<TrainingExample, Integer> each key is a training example, and the associated value is its index in the array list in distance map
 *
 *
 *@Methods
 *+Float getDistance(Feature, Feature): returns a float representing the distance between two features
 *+Float findDistance(TestingExample, TrainingExample): returns a float representing the distance between testing and training example
 *+normalizeDistance(): Sets the map normDist. Divide each distance for a feature type by the max distance of that feature type, for all feature types
 *+updateDistances(): Resets the map of distances so each feature in the Owner (testingexample) has a key and that there is a distance for each training example
 *+Float getEuclideanDistance(): Returns a float representing the distance between two ordered pairs
 *+Float getAbsoluteDistance(): Returns a float representing the distance between two absolute values
 *+Float getSubjectiveDistance(): Returns a float representing the distance between two strings
 *
 */
public class Distance {
//for each feature in test there is a distance between that feature is testing example and each training example
	private Map<String,ArrayList<Float>> distances;
	private Map<String,ArrayList<Float>> normDist;
	private Map<TrainingExample, Integer> lookUpTable;
	private TestingExample testEx;
	//initialize instance's variables
	public Distance(TestingExample testingExample) {
		testEx= testingExample;
		distances = new HashMap<String, ArrayList<Float>>();
		normDist = new HashMap<String, ArrayList<Float>>();
		lookUpTable = new HashMap<TrainingExample, Integer>();
		
	}
	/**
	 * Get position in array list of training example
	 * Go to each entry and add up the distances at that position
	 * How to guarantee that features of a training example will align
	 * 
	 * @param testExam
	 * @param trainExam
	 * @return
	 */
	public float findDistance(TestingExample testExam, TrainingExample trainExam) {
		int index = lookUpTable.get(trainExam);
		int sum=0;
		for (Map.Entry<String, ArrayList<Float>> entry: normDist.entrySet()) {
			if(entry.getValue().get(index)!=null)
				sum+=entry.getValue().get(index);
		}
		return sum;
	}
	/**normalizeDistance will normalize all distances for less biased calculations
	 * 
	 * This will find max distance in the list of distances for a feature, 
	 * then it will divide each distance of that feature by the max
	 */
	public void normalizeDistance() {
		//mi gna super sako
		normDist.clear();
		normDist.putAll(distances);
		float maxDistance=0;
		for (Map.Entry<String, ArrayList<Float>> entry: normDist.entrySet()) {
			for(Float f:entry.getValue()) {//for each element in array in entry
				if(f!=null) {
					if(f>maxDistance) {
						maxDistance=f;
					}
				}
			}
			for(Float f:entry.getValue()) {//for each element in array in entry
				if(f!=null)
					f=f/maxDistance;
			}
		}
	}
	/**updateDistances populates distances dictionary with a key for every feature in testing example, and an array of distances for each training example for each key
	 * 
	 */
	public void updateDistances() {
		String metric="";//this is supposed to be variable, when the algorithm begins to compare features for all training examples
						//prompt the user and ask which distance metric will be used for this feature.
		distances.clear();
		int index=0;
		int lookUpTableFlag =0;
		for (String fName: testEx.getAllFeatures().keySet()) {
			distances.put(fName, new ArrayList<Float>());
		}
	//	for (Map.Entry<String, ArrayList<Float>> entry: normDist.entrySet()) 
		for(Map.Entry<String, ArrayList<Float>> entry: distances.entrySet()) {
			//prompt the user to select distance metric
			for(TrainingExample t: testEx.getExample().getTrainingExamplesModel()) {
				if(lookUpTableFlag==0) {
					lookUpTable.put(t, index);
					index++;
				}
				entry.getValue().add(testEx.getFeature(entry.getKey()).getDistance(t.getFeature(entry.getKey()), metric));
			}
			lookUpTableFlag++;
		}
		normalizeDistance();
	}

}
