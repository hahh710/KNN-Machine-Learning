import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Babak Juniorss
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
	public TestingExample(String name, Example eM) {
		super(name, eM);
		distances = new Distance(this);
		knn=new KNN(0, this);
	}
	/**
	 * Constructor to create copy of training example
	 * @param testEx
	 */

	public Example getManager() {
		return super.getManager();
	}
	public Distance getDistances() {
		return distances;
	}
	public KNN getKNN() {
		return knn;
	}
	/**2
	 * 
	 * PredictFeature
	 * 
	 * @param f
	 * 
	 *            sets the feature value passed in the parameter as the average
	 *            of the list of features in the example class.
	 */
	public void predictFeature(Feature f,CompositeFeature c, int k, HashMap<String, String> metrics) {
		int count = 0;
		distances.updateDistances(metrics);
		knn = new KNN(k, this);
		knn.determineNearestNeighbors(k, getManager().getTrainingExamplesModel());
		if(f instanceof FloatFeature) {
			FloatFeature ff= (FloatFeature) f;
			Float predicted = (float)0;
			for(TrainingExample nn:knn.getNN()) {
				if(nn.getFeature(ff.getStringID("",ff.getParent())) instanceof FloatFeature) {
					predicted+=((FloatFeature)(nn.getFeature(ff.getStringID("", ff.getParent())))).getValue();
					count++;
				}
			}
			predicted=predicted/count;
			f.editOptionFloatFeature(ff.getFName(), predicted, c);
		}
		if (f instanceof StringFeature) {
			StringFeature sf= (StringFeature) f;
			String predicted = "";
			if(knn.getNN().get(0).getFeature(sf.getStringID("", sf.getParent())) instanceof FloatFeature)
				predicted=((StringFeature)(knn.getNN().get(0).getFeature(sf.getStringID("", sf.getParent())))).getFValue();
			super.addStringFeature(sf.getFName(), predicted, c);
		}
		//we have nearest neighbors now we need to determine the value of feature
		if(f instanceof CompositeFeature) {
			/**
			 * 
			 * For each float feature ie dimension in the tuple of floats;
			 * 
			 */
			float sum=0;
			for(Feature ff: ((CompositeFeature) f).getSubFeatures()) {
				sum=0;
				count=0;
				for(TrainingExample nn:knn.getNN()) {
					sum+=((FloatFeature)(nn.getFeature(ff.getStringID("", ff.getParent())))).getValue();
					count++;
				}
				((CompositeFeature) f).addFeature("", (float)sum/count);
			}
			CompositeFeature cf= (CompositeFeature) f;
			for() {
				
			}
			ArrayList<Float> theseFloats = new ArrayList<Float>();

			for(Feature subF: subFeatures){
				if (subF instanceof FloatFeature){
					theseFloats.add(((FloatFeature) subF).getValue());
				}	
			}
			for(Feature subF: f.getSubFeatures()){
				if (subF instanceof FloatFeature){
					thoseFloats.add(((FloatFeature) subF).getValue());
				}	
			}
			if(theseFloats.size()==thoseFloats.size()){
				for(int i=0;i<theseFloats.size();i++){
					value+=Math.pow(theseFloats.get(i),2) - Math.pow(thoseFloats.get(i), 2);
				}
				Float predicted = (float)0;
				for(TrainingExample nn:knn.getNN()) {
					predicted+=nn.getFeature(ff.getStringID());
				}
				predicted=predicted/count;
				super.addFloatFeature(ff.getFName(), predicted, c);
			}
		}
	}
}