import java.awt.event.*;
import javax.swing.*;

public class KNNController implements ActionListener {

	 private KNNView view;
	 private JList<TestingExample> testingExample;
	 private JList <TrainingExample> trainingExample;
	 private Example example;
	 private TestingExample a;
	 private TrainingExample b;
	 private Feature feature;

	 

	public KNNController(KNNView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getActionCommand().equals("Create Example")){
				view.getTestExample().setEnabled(true);
				view.getTrainExample().setEnabled(true);
			 
				example = new Example();
			 
			 
		} else if (event.getActionCommand().equals("Create Training Example")) {
			
			 	view.getFeatureEdit().setEnabled(true);
			 	view.getAddFeature().setEnabled(true);
			 
			 	trainingExample = new JList<>(example.getTrainingExample());
			 	view.getTrainingPanel().add(trainingExample);
			 	trainingExample.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			 	
			 	String nameTrainExample = JOptionPane.showInputDialog(null, "What is name of the Example ?", "Training Example's Name ", JOptionPane.QUESTION_MESSAGE);
			 	
			 	b = new TrainingExample();
			 	b.createExample(nameTrainExample);
			 	example.addTrainingExample(b);

		} else if (event.getActionCommand().equals("Create Testing Example")) {
		 	
			 
		 	testingExample = new JList<>(example.getTestingExample());
		 	view.getTestingPanel().add(testingExample);
		 	testingExample.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 	String nameTestExample = JOptionPane.showInputDialog(null, "What is name of the Example ?", "Training Example's Name ", JOptionPane.QUESTION_MESSAGE);

		    a = new TestingExample(3, example);
		    a.createExample(nameTestExample);
			example.addTestingExample(a);


	} else if (event.getActionCommand().equals("Add Feature")) {
		        view.getFeatureEdit().setEnabled(true);
			 	String featureName = JOptionPane.showInputDialog(null, "What is name of the Feature you would like to be added ?", " Feature's Name ", JOptionPane.QUESTION_MESSAGE);
			 	String featureType = JOptionPane.showInputDialog(null, "What is the type of the Feature you would like to be added(1 for String, 2 for float and 3 for coordinates ?", " Feature's Type ", JOptionPane.QUESTION_MESSAGE);
				
			 	if(featureType.equals("1")) {
			 		String featureSValue = JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE);
				 	b.addFeature(featureName, new Feature(featureSValue));
			 	}
			 	
			 	if(featureType.equals("2")) {
			 		float featureIValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
			 		b.addFeature(featureName, new Feature(featureIValue));
			 	}
			 	
			 	if(featureType.equals("3")) {
			 		int featureXValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is X-Coordinates value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
			 		int featureYValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is Y-Coordinates value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));

				 	b.addFeature(featureName, new Feature(featureXValue,featureYValue));
			 	}
			 	

		} else if (event.getActionCommand().equals("Edit Feature")) {
			
//			BuddyInfo buddyEdit = addressBook.getBuddy(buddyInfo.getSelectedIndex());
//			String nameEdit = buddyEdit.getName();
//			
//			String editAddress = JOptionPane.showInputDialog(null, "What is " + nameEdit + "'s new age?", "Input " + nameEdit + "'s new Age", JOptionPane.QUESTION_MESSAGE);
//			String editNumber = JOptionPane.showInputDialog(null, "What is " + nameEdit + "'s new phone number?", "Input " + nameEdit+ "'s new Phone Number", JOptionPane.QUESTION_MESSAGE);
//			
//			buddyEdit.setAddress(editAddress);
//			buddyEdit.setNumber(editNumber);
			
			String featureName = JOptionPane.showInputDialog(null, "What is name of the Feature you would like to be eddited ?", " Feature's Name ", JOptionPane.QUESTION_MESSAGE);
		 	String featureType = JOptionPane.showInputDialog(null, "What is the type of the Feature you would like to be edit(1 for String, 2 for float and 3 for coordinates ?", " Feature's Type to be editted ", JOptionPane.QUESTION_MESSAGE);
		 	
		 	if(featureType.equals("1")) {
		 		String featureSValue = JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE);
			 	b.addFeature(featureName, new Feature(featureSValue));
		 	}
		 	
		 	if(featureType.equals("2")) {
		 		float featureIValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
		 		b.addFeature(featureName, new Feature(featureIValue));
		 	}
		 	
		 	if(featureType.equals("3")) {
		 		int featureXValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is X-Coordinates value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
		 		int featureYValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is Y-Coordinates value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));

			 	b.addFeature(featureName, new Feature(featureXValue,featureYValue));
		 	}
		 	

		} else if (event.getActionCommand().equals("Predict")) {
			
			String testFeatureName = JOptionPane.showInputDialog(null, "What is name of the Feature you would like to be added ?", " Feature's Name ", JOptionPane.QUESTION_MESSAGE);
		 	int testFeatureType = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the type of the Feature you would like to be added(1 for String, 2 for float and 3 for coordinates ?", " Feature's Type ", JOptionPane.QUESTION_MESSAGE));
			
			a.PredictFeature(testFeatureName, testFeatureType);
				
		} else if (event.getActionCommand().equals("Restart")) {
			new KNNView();
		} 

	}
}
