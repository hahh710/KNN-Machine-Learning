import java.io.Serializable;
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
public class Distance implements Serializable{
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
	 * Go to each feature and add up the distances at that position (training example)
	 * How to guarantee that features of a training example will align???
	 * 
	 * 
	 * finds total distance of each feature between a given test and train example
	 * @param testExam
	 * @param trainExam
	 * @return
	 */
	public float findDistance(TestingExample testExam, TrainingExample trainExam) {
		int index = lookUpTable.get(trainExam);
		int sum=0;
		int count=0;
		for (Map.Entry<String, ArrayList<Float>> entry: normDist.entrySet()) {
			if(entry.getValue().get(index)!=null) {
				sum+=entry.getValue().get(index);
				count++;
			}
		}
		if (count!=0)
			return sum/count;
		return sum;
	}
	/**normalizeDistance will normalize all distances for less biased calculations
	 * 
	 * naming convention, concatenate a composite's children names with its own seperated by a ~
	 * for toString Everything after the ~  
	 * 
	 * This will find max distance in the list of distances for a feature, 
	 * then it will divide each distance of that feature by the max
	 */
	public void normalizeDistance() {
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
	public void populateDistanceMap(CompositeFeature cf) {
		boolean smellyflag=false;
		for(Feature f:cf.getSubFeatures()) {
			smellyflag=false;
			if(f instanceof FloatFeature)
				if(((FloatFeature)f).getValue()!=null)
					smellyflag=true;
			if(f instanceof StringFeature)
				if(((StringFeature)f).getFValue()!=null)	
					smellyflag=true;
			if(f instanceof CompositeFeature)
				if(((CompositeFeature)f).getSubFeatures()!=null)	
					smellyflag=true;		
			if(smellyflag)
				distances.put(f.getStringID("", f), new ArrayList<Float>());
			if(f instanceof CompositeFeature) {
				populateDistanceMap((CompositeFeature)f);
			}
		} 
	}
	/**updateDistances populates distances dictionary with a key for every feature in testing example, and an array of distances for each training example for each key
	 * metrics is a list of metric that will be used for calculating distances for each feature
	 */
	public void updateDistances(HashMap<String, String> metrics) {

		distances.clear();
		int index=0; //index for accessing training examples
		int lookUpTableFlag =0;//this will be triggered when a training example has been puton the map

		//prepare map for distances
		//each feature is a key, with an arraylist of floats representing the distance between a  

		populateDistanceMap(testEx.getFeatures());

		for(Map.Entry<String, ArrayList<Float>> entry: distances.entrySet()) {

			for(TrainingExample t: testEx.getManager().getTrainingExamplesModel()) {
				if(lookUpTableFlag==0) {
					lookUpTable.put(t, index);
					index++;
				}
				if(testEx.getFeature(entry.getKey())!=null && t.getFeature(entry.getKey())!=null)
					entry.getValue().add(testEx.getFeature(entry.getKey()).getDistance(t.getFeature(entry.getKey()), metrics.get(entry.getKey())));
				else {
					entry.getValue().add((Float)null);
				}
			}
			lookUpTableFlag++;
		}
		normalizeDistance();
	}

}
