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
			 	
			 	//gets key for hashmap in training example --> trainingexample.getfeatures.replace(fname, new Feature(value they input)
			 	// 
			 	
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
			 	

		} else if (event.getActionCommand().equals("Edit Testing Example")) {
			
				DefaultListModel<TestingExample> editTest = example.getTestingExample();
				//String editName = editTest.getTrainingExampleName();
			
				//String editTestName = JOptionPane.showInputDialog(null, "What is " + editName + "'s new name?", "Input " + editName + "'s new name", JOptionPane.QUESTION_MESSAGE);
			
				//editTest.setTestName(editTestName);



		} else if (event.getActionCommand().equals("Edit Training Example")) {

				DefaultListModel <TrainingExample> editTrain = example.getTrainingExamples();
				//String editName = editTrain.getExampleName();
				
				//String editTrainName = JOptionPane.showInputDialog(null, "What is " + editName + "'s new name?", "Input " + editName + "'s new name", JOptionPane.QUESTION_MESSAGE);
			
				//editTrain.setTrainName(editTrainName);
			
		} else if (event.getActionCommand().equals("Predict")) {
			
				
		} else if (event.getActionCommand().equals("Restart")) {
			new KNNView();
		} 

	}
}
