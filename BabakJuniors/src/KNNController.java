import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class KNNController implements ActionListener {

	 private KNNView view;
	 private JList <TestingExample>testingExample;
	 private JList <Example>trainingExample;
	 private JList<Feature> feature;

	public KNNController() {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getActionCommand().equals("Create Testing Example")) {
			 view.getTestEdit().setEnabled(true);
			 view.getAddFeature().setEnabled(true);

			 TestingExample testingExample = new TestingExample();

			 testingExample = new JList< >(TestingExample.testingExample);
			
			 view.add(testingExample);

			 testingExample.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			 String name = JOptionPane.showInputDialog(null, "What is testing examples name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);

		} else if (event.getActionCommand().equals("Create Training Feature")) {

			Example trainingExample = new Example();

			 view.getTrainEdit().setEnabled(true);
			 view.getAddFeature().setEnabled(true);

			 String name = JOptionPane.showInputDialog(null, "What is feature's name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);
			 String value = JOptionPane.showInputDialog(null, "What is " + name + "'s value?", "Input " + name + "'s value value", JOptionPane.QUESTION_MESSAGE);

			 feature view = new feature(name, value);
			 trainingExample.addFeature(view);

		} else if (event.getActionCommand().equals("Add Feature")) {

			 String featureName = JOptionPane.showInputDialog(null, "What is feature's name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);
			 String featureValue = JOptionPane.showInputDialog(null, "What is the feature value you would like to add?", "Input feature value: ", JOptionPane.QUESTION_MESSAGE);
			
			// if(featureType.getStringValue!= NULL){
			// 
			//}
			// else if(featureType.getNumValue !=NULL){}
			// else{}
			
			// String value = JOptionPane.showInputDialog(null, "What is " + name + "'s value?", "Input " + name + "'s  value", JOptionPane.QUESTION_MESSAGE);

			// feature view = new feature(name, value);
			// knnAlg.addFeature(view);

		}

		else if (event.getActionCommand().equals("Edit Testing Example")) {

			// view.getTestEdit().setEnabled(true);

			 String name = JOptionPane.showInputDialog(null, "What is feature's name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);
			 String value = JOptionPane.showInputDialog(null, "What is " + name + "'s  value?", "Input " + name + "'s value ", JOptionPane.QUESTION_MESSAGE);

			 feature view = new feature(name, value);
			 knnAlg.addFeature(view);

		} else if (event.getActionCommand().equals("Edit Training Example")) {

			 Example featureEdit = trainingExample.getFeature(feature.getSelectedIndex());
			 String nameEdit = featureEdit.getName();

			 String editFeatureName = JOptionPane.showInputDialog(null, "What is feature's name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);
			 String editFeatureValue = JOptionPane.showInputDialog(null, "What is " + nameEdit + "'s value?", "Input " + nameEdit + "'s value ", JOptionPane.QUESTION_MESSAGE);

			 featureEdit.setFeatureName(editFeatureName);
			 featureEdit.setFeatureValue(editFeatureValue);
		}

		else if (event.getActionCommand().equals("Predict")) {

			// feature featureEdit = knnAlg.getBuddy(feature.getSelectedIndex());
			 String nameEdit = featureEdit.getName();

			 String editFeatureName = JOptionPane.showInputDialog(null, "What is feature's name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);
			 String editFeatureValue = JOptionPane.showInputDialog(null, "What is " + nameEdit + "'s value?", "Input " + nameEdit + "'s value ", JOptionPane.QUESTION_MESSAGE);

			 featureEdit.setFeatureName(editFeatureName);
			 featureEdit.setFeatureValue(editFeatureValue);
		}

	}
}
