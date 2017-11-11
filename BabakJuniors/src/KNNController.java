import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class KNNController implements ActionListener {

	 private KNNView view;
	 private JList<TestingExample> testingExamples;
	 private JList <TrainingExample>trainingExample;
	 private JList<Feature> feature;
	 private Example example;
	 

	public KNNController(KNNView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getActionCommand().equals("Create Example")) {
			
			 
			 example = new Example();
			 
			 view.getTestExample().setEnabled(true);
			 view.getTrainExample().setEnabled(true);
		}
		else if (event.getActionCommand().equals("Create Testing Example")) {
			
			 //Enter the knn value...create an option dialogue box here...
			// String name = JOptionPane.showInputDialog(null, "What is testing examples name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);

			 	testingExamples = new JList<>(example.testExamples);
			 	view.add(testingExamples);
		

			 	testingExamples.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			 
			    TestingExample a = new TestingExample(null, 0, example);
				example.addTestingExample(a);


		} else if (event.getActionCommand().equals("Create Training Feature")) {
			
			 trainingExample = new JList<>(example.trainingExamples);
			 view.add(trainingExample);
		

			 trainingExample.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			 TrainingExample b = new TestingExample(null, 0, example);
			 example.addTrainingExample(b);

		} else if (event.getActionCommand().equals("Add Feature")) {

//			 String featureName = JOptionPane.showInputDialog(null, "What is feature's name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);
			// while(featureNamecheckFeatureType() != true) {
//				 featureName = JOptionPane.showInputDialog(null, "The Feature type hasnt been initialized, please enter a feature type that already exists");
			// } 
//			 String featureType = JOptionPane.showInputDialog(null, "What is the feature type you would like to add?", "Input feature value: ", JOptionPane.QUESTION_MESSAGE);
			
			// if(featureValue.getStringValue!= NULL){
			// 
			//}
			// else if(featureValue.getNumValue !=NULL){}
			// else{}
			
			// String value = JOptionPane.showInputDialog(null, "What is " + name + "'s value?", "Input " + name + "'s  value", JOptionPane.QUESTION_MESSAGE);

			// feature view = new feature(name, value);
			// knnAlg.addFeature(view);
			 

		} 
	else if (event.getActionCommand().equals("Edit Testing Example")) {

			// view.getTestEdit().setEnabled(true);

			// String name = JOptionPane.showInputDialog(null, "What is feature's name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);
			 //String value = JOptionPane.showInputDialog(null, "What is " + name + "'s  value?", "Input " + name + "'s value ", JOptionPane.QUESTION_MESSAGE);

			// feature view = new feature(name, value);
			// knnAlg.addFeature(view);

		} else if (event.getActionCommand().equals("Edit Training Example")) {

			// Example featureEdit = trainingExample.getFeature(feature.getSelectedIndex());
			// String nameEdit = featureEdit.getName();

			// String editFeatureName = JOptionPane.showInputDialog(null, "What is feature's name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);
			// String editFeatureValue = JOptionPane.showInputDialog(null, "What is " + nameEdit + "'s value?", "Input " + nameEdit + "'s value ", JOptionPane.QUESTION_MESSAGE);

			// featureEdit.setFeatureName(editFeatureName);
			// featureEdit.setFeatureValue(editFeatureValue);
		}

		else if (event.getActionCommand().equals("Predict")) {

			// feature featureEdit = knnAlg.getBuddy(feature.getSelectedIndex());
			// String nameEdit = featureEdit.getName();

			 //String editFeatureName = JOptionPane.showInputDialog(null, "What is feature's name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);
			// String editFeatureValue = JOptionPane.showInputDialog(null, "What is " + nameEdit + "'s value?", "Input " + nameEdit + "'s value ", JOptionPane.QUESTION_MESSAGE);

			// featureEdit.setFeatureName(editFeatureName);
			// featureEdit.setFeatureValue(editFeatureValue);
		}

	}
}
