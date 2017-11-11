import java.util.ArrayList;

public class Example {
	ArrayList<TrainingExample> trainingExamples;

	ArrayList<TestingExample> testExamples;
	ArrayList<String> type;
	// ArrayList<ArrayList<String>>rank;
	ArrayList<Rank> rank;
	// ArrayList<String>rank;//Rank for subjective features

	public Example() {
		trainingExamples = new ArrayList<TrainingExample>();
		testExamples = new ArrayList<TestingExample>();
		type = new ArrayList<String>();
		rank = new ArrayList<Rank>();
	}

	public void addTrainingExample(TrainingExample example) {
		trainingExamples.add(example);
		//?abstractkey(example);
	}

	public ArrayList<TrainingExample> getTrainingExamples() {
		return trainingExamples;
	}

	public void addTestingExample(TestingExample example) {
		testExamples.add(example);
	}

	public ArrayList<TestingExample> getTestingExample() {
		return testExamples;
	}
//createFeatureType
//checkFeatureType
	public void abstractkey(TrainingExample example) {
		for (int i = 0; i < example.getNameSet().size(); i++) {
			if (!type.contains(example.getNameSet().get(i))) {
				if (checkSubjective(example.getFeature(example.getNameSet().get(i)))) {
					type.add(example.getNameSet().get(i));
				} else
					type.add(example.getNameSet().get(i));
			} // else print error message that there is exist name;

			/*
			 * if(type.isEmpty()){
			 * if(checkSubjective(example.getFeature(example.getNameSet().get(i)
			 * ))){ //rank.add(example.getNameSet().get(i));
			 * type.add(example.getNameSet().get(i)); }else
			 * type.add(example.getNameSet().get(i)); }else
			 * if(!type.contains(example.getNameSet().get(i))){
			 * if(checkSubjective(example.getFeature(example.getNameSet().get(i)
			 * ))){ type.add(example.getNameSet().get(i)); }else
			 * type.add(example.getNameSet().get(i)); }
			 */// else print error message that there is exist name;
		}
	}

	public void createFeatureType(String featureName, Feature feature) {
		boolean flag = true;
		for (int i = 0; i < rank.size(); i++) {
			if (rank.get(i).checkName(featureName)) {
				flag = false;
			}
		}
		if (flag) {
			rank.add(new Rank(featureName, feature));
		} else {
			System.out.println("There is existing feature Name");
		}
	}

	public void appendRank(String featureName, Feature feature) {
		// boolean go to ranking featureName.add(feature.getStringValue)
	}

	public boolean checkSubjective(Feature feature) {
		if (feature.getStringValue() != null)
			return true;
		else
			return false;
	}
	
	public boolean checkAbsolute(Feature feature) {
		if (feature.getNumValue()!=null)
			return true;
		else
			return false;
	}
	public boolean checkEuclidean(Feature feature) {
		if (feature.getCorX()!=null && feature.getCorY()!=null)
			return true;
		else
			return false;
	}
}
