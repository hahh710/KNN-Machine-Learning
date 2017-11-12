import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Distance {
//for each feature in test there is a distance between that and 
	private Map<String,ArrayList<Float>> distances;
	private Map<String,ArrayList<Float>> normDist;
	private Map<TrainingExample, Integer> lookUpTable;
	private TestingExample testEx;
	public Distance(TestingExample testingExample, ArrayList<TrainingExample> trainingExamples) {
		testEx= testingExample;
		distances = new HashMap<String, ArrayList<Float>>();
		normDist = new HashMap<String, ArrayList<Float>>();
		lookUpTable = new HashMap<TrainingExample, Integer>();
		
	}
	public Float getDistance(Feature train, Feature test){
		if(test.getCorX()!=null){
			return getEuclideanDistance(train, test);
		}
		if(test.getStringValue)!=null){
			return getSubjectiveDistance(train, test);
		}
		if(test.getNumValue()!=null){
			return getAbsoluteDistance(train, test);
		}
		return null;
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
			sum+=entry.getValue().get(index);
		}
		return sum;
	}
	/**
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
				f=f/maxDistance;
			}
		}
	}
	/**
	 * 
	 */
	public void updateDistances() {
		distances.clear();
		int index=0;
		int lookUpTableFlag =0;
		for (Feature f: testEx.getAllFeatures()) {
			distances.put(f.getFName(), new ArrayList<Float>());
		}
	//	for (Map.Entry<String, ArrayList<Float>> entry: normDist.entrySet()) 
		
		for (Feature f: testEx.getAllFeatures()) {
			for(TrainingExample t: testEx.getExample().getTrainingExamples()) {
				if(lookUpTableFlag==0) {
					lookUpTable.put(t, index);
					index++;
				}
				distances.get(f.getFName()).add(getDistance(f, t.getFeature(f.getFName())));
			}
			lookUpTableFlag++;
		}
	}
	public float getEuclideanDistance(Feature train, Feature test){
		return (float) Math.sqrt(Math.pow(train.getCorX() - test.getCorX(), 2) + Math.pow(train.getCorY() - test.getCorY(), 2)));
	}
	public float getSubjectiveDistance(Feature train, Feature test){
		return train.getRank()-test.getRank();
	}
	public float getAbsoluteDistance(Feature train, Feature test){
		return train.getNumValue()-test.getNumValue();
	}
}
