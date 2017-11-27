import java.util.ArrayList;

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
public class Example {
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
	 * 
	 * @param trainingExample
	 *            example used to calculate error, turned into testing example
	 *            and predicts a feature
	 * @param Feature: 
	 *            the feature to be predicted
	 * @param k:
	 *            the number
	 * @return 
	 */
	public float calculateError(TrainingExample trainEx, Feature f, int k) {
		return k;
			
		//testytest.predict()
		//thefeaturejustpredicted.calculateerror(trainEx.getfeaturebeingcalculated);
		
	}
}

 
