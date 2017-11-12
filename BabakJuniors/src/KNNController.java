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
			
				//TestingExample editTest = example.getTestingExample();
				//String editName = editTest.getExampleName();
			
				//String editTestName = JOptionPane.showInputDialog(null, "What is " + editName + "'s new name?", "Input " + editName + "'s new name", JOptionPane.QUESTION_MESSAGE);
			
				//editTest.setTrainName(editTestName);



		} else if (event.getActionCommand().equals("Edit Training Example")) {

				//TrainingExample editTrain = example.getTrainingExample();
				//String editName = editTrain.getExampleName();
				
				//String editTrainName = JOptionPane.showInputDialog(null, "What is " + editName + "'s new name?", "Input " + editName + "'s new name", JOptionPane.QUESTION_MESSAGE);
			
				//editTrain.setTrainName(editTrainName);
			
		} else if (event.getActionCommand().equals("Predict")) {
			
				
		} else if (event.getActionCommand().equals("Restart")) {
			new KNNView();
		} 

	}
}
