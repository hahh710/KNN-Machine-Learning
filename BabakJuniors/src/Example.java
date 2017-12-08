import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;

/**
 * 
 * @author Babak Juniors
 * @Purpose: This class contains all the list of training and testing example and contains all the methods related to adding, and appending rank and creating
									feature type for each example and contains methods related to feature types. and eventually calculuates error
 *
 * @field variables - 
 * 					-  trainingExamples : DefaultListModel<TrainingExample>
					- trainingExamplesModel : ArrayList<TrainingExample>
					-  testingExamples : DefaultListModel<TestingExample>
 * 
 * @methods + addTrainingExample( example :TrainingExample) : void 
			+ getTrainingExamples() : DefaultListModel<TrainingExample>
			+ getTrainingExamplesModel() : ArrayList<TrainingExample>
			+ addTestingExample( example : TestingExample) : void
			+ getTestingExample() : DefaultListModel<TestingExample>
			+ abstractkey(example: TrainingExample ) :  void 
			+ createFeatureType(featureName : String , feature : Feature) : void
			+ getTrainingExampleIndex(i : int) : TrainingExample
			+ getTestingExampleIndex(i: int) : TestingExample
			+ toString() : String
			+ calculateError( tEx : TrainingExample, f : Feature, k : int) :  float
 */
public class Example implements Serializable{

	

	/**
	 * 
	 */
	//private static final long serialVersionUID = -6982460538886781926L;
	private DefaultListModel<TrainingExample> trainingExamples;
	private ArrayList<TrainingExample> trainingExamplesModel;
	private DefaultListModel<TestingExample> testingExamples;
	/**
	 * Constructor for the Example class which initializes all the instance
	 * variables
	 */
	public Example() {
		trainingExamples = new DefaultListModel<TrainingExample>();
		trainingExamplesModel = new ArrayList<TrainingExample>();
		testingExamples = new DefaultListModel<TestingExample>();

	}

	/**
	 * addTrainingExample add the example passed in by the parameters to the
	 * DefaultListmodel
	 * 
	 * @param example
	 */
	public void addTrainingExample(TrainingExample example) {
		trainingExamples.addElement(example);
		trainingExamplesModel.add(example);
	}


	/**
	 * getTrainingExamples returns the list of training example
	 * 
	 * @return trainingExample
	 */
	public DefaultListModel<TrainingExample> getTrainingExamples() {
		return trainingExamples;
	}

	/**
	 * getTrainingExamples returns the list of training example
	 * 
	 * @return trainingExample
	 */
	public DefaultListModel<TrainingExample> getTrainingExample() {
		return trainingExamples;
	}
	public void setTestingExamples(DefaultListModel<TestingExample> testingExamples) {
		this.testingExamples = testingExamples;
	}

	public void setTrainingExamples(DefaultListModel<TrainingExample> trainingExamples) {
		this.trainingExamples = trainingExamples;
	}

	/**
	 * getTrainingExamplesModel returns the list of training example model
	 * 
	 * @return trainingExample
	 */
	public ArrayList<TrainingExample> getTrainingExamplesModel() {
		return trainingExamplesModel;
	}

	/**
	 * addTestingExample adds an example to the testingExample list
	 * 
	 * @param example
	 */
	public void addTestingExample(TestingExample example) {
		testingExamples.addElement(example);
	}


	/**
	 * getTestingExample returns the list of testingExample
	 * 
	 * @return testingExample
	 */
	public DefaultListModel<TestingExample> getTestingExample() {
		return testingExamples;
	}




	/**getTrainingExampleIndex returns the element at index in training examples
	 * @param i
	 * @return
	 */
	public TrainingExample getTrainingExampleIndex(int i) {
		return trainingExamples.getElementAt(i);
	}

	/**getTestingExampleIndex returns the element at index in testing examples
	 * @param i
	 * @return
	 */
	public TestingExample getTestingExampleIndex(int i) {
		return testingExamples.getElementAt(i);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * this returns each name of example into toString string variable.

	public String toString(){
		String toString = "";

		for (int i = 0; i < trainingExamples.size(); i++) {
			toString += trainingExamples.get(i).getExampleName() + ": " + trainingExamples.get(i).toString();
			// toString();
		}
		for (int i = 0; i < testingExamples.size(); i++) {
			toString += testingExamples.get(i).getExampleName() + ": " + testingExamples.get(i).toString();
		}
		return toString;
	}
	 */
	/**
	 * predictFeatureSet
	 * 
	 * @param fID: is the id that represents a feature
	 * @param k: is the number of neighbors that predict will use
	 * @param metrics: is a set of metrics each feature will be using for the calculation
	 * 
	 * this method will predict the feature for every testing example that does not have a value for the given feature 
	 */
	public DefaultListModel<Feature> predictFeatureSet(String fID, int k, HashMap<String, String> metrics) {
		DefaultListModel <Feature> listOfPredictions = new DefaultListModel<Feature>();
		for(int i =0; i<testingExamples.getSize();i++) {
			if(testingExamples.getElementAt(i).getFeature(fID)==null)
				listOfPredictions.addElement(testingExamples.getElementAt(i).predictFeature(testingExamples.getElementAt(i).getFeature(fID), k, metrics));
			else
				listOfPredictions.addElement(null);
		}
		return listOfPredictions;
	}
	//	public Float calculateError(Feature f, int k, HashMap<String, String> metrics) {
}


