import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class KNNController implements ActionListener {

	 private KNNView view;
	 private JList<TestingExample> testingExamples;
	 private JList <TrainingExample>trainingExample;
	 private JList<Feature> feature;
	 private Example example;
	 private TestingExample a;
	 private TrainingExample b;
	 

	public KNNController(KNNView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getActionCommand().equals("Create Example")) {
			
			view.getTestExample().setEnabled(true);
			view.getTrainExample().setEnabled(true);
			 
			 example = new Example();
			 
			 
		} else if (event.getActionCommand().equals("Create Testing Example")) {
			 view.getTestEdit().setEnabled(true);
			 
			
			   int knnV = Integer.parseInt(JOptionPane.showInputDialog(null, "What is knn value?", "KNN's value", JOptionPane.QUESTION_MESSAGE));

			 	testingExamples = new JList<>(example.testExamples);
			 	//testingExamples = new JList<>(TrainingExample.nameSet);

			 	view.getTestingPanel().add(testingExamples);
		

			 	testingExamples.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			 
			    a = new TestingExample(null, knnV, example);
				example.addTestingExample(a);


		} else if (event.getActionCommand().equals("Create Training Example")) {
			 view.getTrainEdit().setEnabled(true);
			 view.getAddFeature().setEnabled(true);
			 
			 trainingExample = new JList<>(example.trainingExamples);
			 view.getTrainingPanel().add(trainingExample);
		

			 trainingExample.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			 String nameExample = JOptionPane.showInputDialog(null, "What is name of the Example ?", "Training Example's Name ", JOptionPane.QUESTION_MESSAGE);
			 b = new TrainingExample();
			 b.createExample(nameExample);
		
			 example.addTrainingExample(b);

		} else if (event.getActionCommand().equals("Add Feature")) {

			 String featureName = JOptionPane.showInputDialog(null, "What is name of the Feature you would like to be added ?", " Feature's Name ", JOptionPane.QUESTION_MESSAGE);
			 //get the feature type 
			 //set it to a string, int or coordinates
			 b.addFeature(featureName, new Feature("Enter the feature amount here"));

		} else if (event.getActionCommand().equals("Edit Testing Example")) {
			TestingExample editTrain = example.getTestingExample()
			


		} else if (event.getActionCommand().equals("Edit Training Example")) {

			// Example featureEdit = trainingExample.getFeature(feature.getSelectedIndex());
			// String nameEdit = featureEdit.getName();

			// String editFeatureName = JOptionPane.showInputDialog(null, "What is feature's name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);
			// String editFeatureValue = JOptionPane.showInputDialog(null, "What is " + nameEdit + "'s value?", "Input " + nameEdit + "'s value ", JOptionPane.QUESTION_MESSAGE);

			// featureEdit.setFeatureName(editFeatureName);
			// featureEdit.setFeatureValue(editFeatureValue);
		} else if (event.getActionCommand().equals("Predict")) {

			
		} else if (event.getActionCommand().equals("Restart")) {
			new KNNView();
		} 

	}
}
