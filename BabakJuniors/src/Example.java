import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Example {
	private DefaultListModel<TrainingExample> trainingExamples;
	private ArrayList<TrainingExample> trainingExamplesModel;
	private DefaultListModel<TestingExample> testingExamples;
	private ArrayList<String> type;
	//ArrayList<ArrayList<String>>rank;
	private ArrayList<Rank> rank;
	//ArrayList<String>rank;//Rank for subjective features

	public Example() {
		trainingExamples = new DefaultListModel<TrainingExample>();
		trainingExamplesModel = new ArrayList<TrainingExample>();
		testingExamples = new DefaultListModel<TestingExample>();
		type = new ArrayList<String>();
		rank = new ArrayList<Rank>();
	}

	public void addTrainingExample(TrainingExample example) {
		trainingExamples.addElement(example);
		trainingExamplesModel.add(example);
		//?abstractkey(example);
	}

	public DefaultListModel<TrainingExample> getTrainingExamples() {
		return trainingExamples;
	}
	
	public DefaultListModel<TrainingExample> getTrainingExample(){
		return trainingExamples;
	}
	
	public ArrayList<TrainingExample> getTrainingExamplesModel(){
		return trainingExamplesModel;
	}
	public void addTestingExample(TestingExample example) {
		testingExamples.addElement(example);
	}

	public DefaultListModel<TestingExample> getTestingExample() {
		return testingExamples;
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
		for(int i = 0; i< rank.size() ;i++){
			if(rank.get(i).checkName(featureName)){
				if(!rank.get(i).getlist().contains(feature)){
					rank.get(i).getlist().add(feature);
				}
			}
		}
	}
	public Rank getRankingList(String fName){
		for(Rank r: rank) {
			if(fName == r.getName())
				return r;
		}
		return null;
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
		for(int i =0;i<testingExamples.size();i++){
			toString += testingExamples.get(i).getExampleName()+": " +testingExamples.get(i).toString();
		}
		return toString;
	}	
/**
 * 
 * @param tEx:training example used to calculate error, turned into testing example and predicts a feature
 * @param f: the feature to be predicted
 * @param k: the number 
 * @return
 */
	public float calculateError(TrainingExample tEx, Feature f, int k) {
		float error =0;
		TestingExample testytest = new TestingExample(tEx, k ,this); //create a test example to predict
		int smellyTypeFlag=0;//flag will identify which type of value for the predict method... must refactor 
		float expectedValue, actualValue, expectedValue2, actualValue2;
		if(f.getStringValue()!=null) {//subjective type handler
			expectedValue=(float)f.getRank();
			smellyTypeFlag=1;
			testytest.predictFeature(f.getFName(), smellyTypeFlag);
			actualValue=(float) testytest.getFeature(f.getFName()).getRank();
			error=Math.abs(expectedValue-actualValue)/expectedValue;
			tEx.editFeature(f.getFName(), new Feature(this.getRankingList(f.getFName()).getValueAtRank((int)expectedValue)));//revert the original value to the training example
		}
		else if(f.getCorX()!=null) { //ordered paid type handler
			expectedValue=(float)f.getCorX();
			expectedValue2=(float)f.getCorY();
			smellyTypeFlag=2;
			testytest.predictFeature(f.getFName(), smellyTypeFlag);
			actualValue=(float) testytest.getFeature(f.getFName()).getCorX();
			actualValue2=(float) testytest.getFeature(f.getFName()).getCorY();
			error=(Math.abs(expectedValue-actualValue)/expectedValue+Math.abs(expectedValue2-actualValue2)/expectedValue2)/2;
			tEx.editFeature(f.getFName(), new Feature((int)expectedValue,(int) expectedValue2));//revert the original f value
		}
		else if(f.getNumValue()!=null) { //absolute type handler
			expectedValue = f.getNumValue();
			smellyTypeFlag=3;
			testytest.predictFeature(f.getFName(), smellyTypeFlag);
			actualValue=(float) testytest.getFeature(f.getFName()).getNumValue();
			error=Math.abs(expectedValue-actualValue)/expectedValue;
			tEx.editFeature(f.getFName(), new Feature(expectedValue));//revert to the original f value
		}
		return error;
	}
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
//instead of attempting to copy these complex objects
//make a testingExample made out of a particular training example
//call predict on a feature, compare that value to feature value
/**
public float calculateError(TrainingExample trainEx, Feature f) {
	TrainingExample storeTestCase=new TrainingExample(trainEx);
	TestingExample storeThisState= new TestingExample(this);
	Feature storeFeature;
	float error=0;
	//check which feature type it is and then predict accordingly
	if(f.getStringValue()!=null) {
		float actual, expected;
		expected=(float)f.getRank();
		storeFeature = new Feature (f.getStringValue());
	}
	if(f.getCorX()!=null) {
		float actualx, actualy, expectedx, expectedy;
		expectedx=(float)f.getCorX();
		expectedy=(float)f.getCorY();
		storeFeature = new Feature (f.getCorX(), f.getCorY());
	}
	if(f.getNumValue()!=null) {
		float actual, expected;
		expected = f.getNumValue();
		storeFeature = new Feature (f.getNumValue());
	}
	return error;
}*/
