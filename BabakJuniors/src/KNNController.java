import java.awt.event.*;
import javax.swing.*;

public class KNNController implements ActionListener {

	 private KNNView view;
	 private JList<TestingExample> testingExample;
	 private JList <TrainingExample> trainingExample;
	 private Example example;
	 private TestingExample testingEx;
	 private TrainingExample trainingEx;
	 

	 

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
			 	
			 	trainingExample.setSelectionMode((ListSelectionModel.SINGLE_SELECTION));	
			 	
			 	String nameTrainExample = JOptionPane.showInputDialog(null, "What is name of the Example ?", "Training Example's Name ", JOptionPane.QUESTION_MESSAGE);
			 	trainingEx = new TrainingExample();
			 	trainingEx.createExample(nameTrainExample);
			 	example.addTrainingExample(trainingEx);
			 	
			 	
			 	
			 	
				
			 	
		} else if (event.getActionCommand().equals("Create Testing Example")) {
			view.getTestFeature().setEnabled(true);
			 
		 	testingExample = new JList<>(example.getTestingExample());
		 	view.getTestingPanel().add(testingExample);
	
		 	testingExample.setSelectionMode(((ListSelectionModel.SINGLE_SELECTION)));
		 	String nameTestExample = JOptionPane.showInputDialog(null, "What is name of the Training Example ?", "Training Example's Name ", JOptionPane.QUESTION_MESSAGE);

		    testingEx = new TestingExample(example);
		    testingEx.createExample(nameTestExample);
			example.addTestingExample(testingEx);
			

	} else if (event.getActionCommand().equals("Add Feature")) {
		         view.getFeatureEdit().setEnabled(true);
		        
		         //trainingEx = example.getTrainingExampleIndex(trainingExample.getSelectedIndex());
		         int i = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to add the feature ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
		         trainingEx = example.getTrainingExampleIndex(i);

		         
		        
			    String featureName = JOptionPane.showInputDialog(null, "What is name of the Feature you would like to be added ?", " Feature's Name ", JOptionPane.QUESTION_MESSAGE);
			 	String featureType = JOptionPane.showInputDialog(null, "What is the type of the Feature you would like to be added(1 for String, 2 for float and 3 for coordinates ?", " Feature's Type ", JOptionPane.QUESTION_MESSAGE);
				
			 	if(featureType.equals("1")) {
			 		String featureSValue = JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE);
				 	trainingEx.addFeature(featureName, new Feature(featureSValue));
			 	}
			 	
			 	if(featureType.equals("2")) {
			 		float featureIValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
			 		trainingEx.addFeature(featureName, new Feature(featureIValue));
			 		
			 	}
			 	
			 	if(featureType.equals("3")) {
			 		int featureXValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is X-Coordinates value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
			 		int featureYValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is Y-Coordinates value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));

				 	trainingEx.addFeature(featureName, new Feature(featureXValue,featureYValue));
			 	}
			 	

		}else if (event.getActionCommand().equals("Add Testing Feature")) {
	         view.getFeatureEdit().setEnabled(true);
	         
	         
	         
	         //trainingEx = example.getTrainingExampleIndex(trainingExample.getSelectedIndex());
	         int l = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to add the feature ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
	         testingEx = example.getTestingExampleIndex(l);

	         
	        
		    String featureName = JOptionPane.showInputDialog(null, "What is name of the Feature you would like to be added ?", " Feature's Name ", JOptionPane.QUESTION_MESSAGE);
		 	String featureType = JOptionPane.showInputDialog(null, "What is the type of the Feature you would like to be added(1 for String, 2 for float and 3 for coordinates ?", " Feature's Type ", JOptionPane.QUESTION_MESSAGE);
			
		 	if(featureType.equals("1")) {
		 		String featureSValue = JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE);
		 		testingEx.addFeature(featureName, new Feature(featureSValue));
		 	}
		 	
		 	if(featureType.equals("2")) {
		 		float featureIValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
		 		testingEx.addFeature(featureName, new Feature(featureIValue));
		 		
		 	}
		 	
		 	if(featureType.equals("3")) {
		 		int featureXValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is X-Coordinates value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
		 		int featureYValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is Y-Coordinates value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));

		 		testingEx.addFeature(featureName, new Feature(featureXValue,featureYValue));
		 	}
		 	

	}else if (event.getActionCommand().equals("Edit Feature")) {
			
	//		TrainingExample buddyEdit = example.getTrainingExampleIndex((trainingExample.getSelectedIndex()));
	//		String nameEdit = buddyEdit.getName();
//			
//			String editAddress = JOptionPane.showInputDialog(null, "What is " + nameEdit + "'s new age?", "Input " + nameEdit + "'s new Age", JOptionPane.QUESTION_MESSAGE);
//			String editNumber = JOptionPane.showInputDialog(null, "What is " + nameEdit + "'s new phone number?", "Input " + nameEdit+ "'s new Phone Number", JOptionPane.QUESTION_MESSAGE);
//			
//			buddyEdit.setAddress(editAddress);
//			buddyEdit.setNumber(editNumber);
			
			String editFeatureName = JOptionPane.showInputDialog(null, "What is the new name of the Feature you would like to be eddited ?", " Feature's Name ", JOptionPane.QUESTION_MESSAGE);
		 	String featureType = JOptionPane.showInputDialog(null, "What is the new type of the Feature you would like to edit(1 for String, 2 for float and 3 for coordinates ?", " Feature's Type to be editted ", JOptionPane.QUESTION_MESSAGE);
		 	
		 	if(featureType.equals("1")) {
		 		String featureSValue = JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE);
		 		//trainingEx.editFeature(editFeatureName, featureSValue);
			 	//trainingEx.addFeature(featureName, new Feature(featureSValue));
		 	}
		 	
		 	if(featureType.equals("2")) {
		 		float featureIValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
		 		//trainingEx.editFeature(editFeatureName, featureCValue);
		 		//trainingEx.addFeature(featureName, new Feature(featureIValue));
		 	}
		 	
		 	if(featureType.equals("3")) {
		 		int featureXValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is X-Coordinates value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
		 		int featureYValue = Integer.parseInt(JOptionPane.showInputDialog(null, "What is Y-Coordinates value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
		 		//trainingEx.editFeature(editFeatureName, featureSValue);
			 	//trainingEx.addFeature(featureName, new Feature(featureXValue,featureYValue));
		 	}
		 	

		} else if (event.getActionCommand().equals("Predict")) {
			view.getCalculateError().setEnabled(true);  
			
			String testFeatureName = JOptionPane.showInputDialog(null, "What is name of the Feature you would like to be added ?", " Feature's Name ", JOptionPane.QUESTION_MESSAGE);
		 	int knn = Integer.parseInt(JOptionPane.showInputDialog(null, "How many K-Nearest-Neighbours are there?", " KNN Value ", JOptionPane.QUESTION_MESSAGE));
		 	int testFeatureType = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the type of the Feature you would like to be added(1 for String, 2 for float and 3 for coordinates ?", " Feature's Type ", JOptionPane.QUESTION_MESSAGE));

			testingEx.predictFeature(testFeatureName, testFeatureType, knn);
			
				
		}
	else if (event.getActionCommand().equals("CalculateError")) {
			
			

			//example.calculateError(tEx, f, k)
			
				
		} else if (event.getActionCommand().equals("Restart")) {
			new KNNView();
		} 

	}
}
