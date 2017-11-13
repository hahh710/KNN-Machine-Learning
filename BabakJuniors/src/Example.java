import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Example {
	DefaultListModel<TrainingExample> trainingExamples;
	ArrayList<TrainingExample> trainingExamplesModel;
	DefaultListModel<TestingExample> testExamples;
	DefaultListModel<String> type;
	//ArrayList<ArrayList<String>>rank;
	DefaultListModel<Rank> rank;
	//ArrayList<String>rank;//Rank for subjective features

	public Example() {
		trainingExamples = new DefaultListModel<TrainingExample>();
		trainingExamplesModel = new ArrayList<TrainingExample>();
		testExamples = new DefaultListModel<TestingExample>();
		type = new DefaultListModel<String>();
		rank = new DefaultListModel<Rank>();
	}

	public void addTrainingExample(TrainingExample example) {
		trainingExamples.addElement(example);
		trainingExamplesModel.add(example);
		//?abstractkey(example);
	}

	public DefaultListModel<TrainingExample> getTrainingExamples() {
		return trainingExamples;
	}
	public ArrayList<TrainingExample> getTrainingExamplesModel(){
		return trainingExamplesModel;
	}
	public void addTestingExample(TestingExample example) {
		testExamples.addElement(example);
	}

	public DefaultListModel<TestingExample> getTestingExample() {
		return testExamples;
	}
//createFeatureType
//checkFeatureType
	public void abstractkey(TrainingExample example) {
		for (int i = 0; i < example.getNameSet().size(); i++) {
			if (!type.contains(example.getNameSet().get(i))) {
				if (checkSubjective(example.getFeature(example.getNameSet().get(i)))) {
					type.addElement(example.getNameSet().get(i));
				} else
					type.addElement(example.getNameSet().get(i));
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
			rank.addElement(new Rank(featureName, feature));
		} else {
			System.out.println("There is existing feature Name");
		}
	}

	public void appendRank(String featureName, Feature feature) {
		// boolean go to ranking featureName.add(feature.getStringValue)
		for(int i = 0; i< rank.size() ;i++){
			if(rank.get(i).checkName(featureName)){
				if(!rank.get(i).getlist().contains(feature)){
					rank.get(i).getlist().add(feature);
				}
			}
		}
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
	
	public String toString(){
		String toString = "";
		
		for(int i =0;i<trainingExamples.size();i++){
			toString += trainingExamples.get(i).getExampleName()+": " +trainingExamples.get(i).toString();
					//toString();
		}
		for(int i =0;i<testExamples.size();i++){
			toString += testExamples.get(i).getExampleName()+": " +testExamples.get(i).toString();
		}
		return toString;
	}
	
	/**
	 * Create a copy of a training example
	 * delete that training example from training examples
	 * create a testing example from training example
	 * (create new constructor for testing example which accepts a training example as parameter and copies its feature map)
	 * create a copy of a feature
	 * then delete that feature
	 * then predict that feature
	 * then calculate error on the difference
	 */
	public void calculateError() {
		
		
	}
	
	
}
