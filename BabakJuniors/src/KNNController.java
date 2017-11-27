import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
/**
 * The controller part of the MVC model
 *
 * @Authors: Ahmed Khattab
 * @Purpose: Determine the nearest neighbors of a given testing example, given a certain K
 * append a string for each feature, pass this string to predict
 * prompt: what is the distance metric you would like to use for print FNAME
 * append input to list
 *
 * @field variables
 * - nearestNeighbors ArrayList<TrainingExamples>: represents the list of nearest neighbors
 * - k int: represents the number of nearest neighbors
 * - testEx Testing Example: represents the reference to the owner of this instance
 * 
 * @methods 
 * actionperformed(event):
 *
 *
 */
public class KNNController implements ActionListener {

	 private KNNView view;
	 private JList<TestingExample> testingExample;
	 private JList <TrainingExample> trainingExample;
	 private Example example;
	 private TestingExample testingEx;
	 private TrainingExample trainingEx;
	 private HashMap <String, String> distanceMetrics;
	 private String featureName;
	 private String featureType;
	 private String featureSValue;
	 private float featureFValue;
	 private CompositeFeature featureHead;
	 private CompositeFeature newCurrent;
	 
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
			
			 	view.getFeatureTrainEdit().setEnabled(true);
			 	view.getTrainFeature().setEnabled(true);
			 	
			 	trainingExample = new JList<>(example.getTrainingExample()); 	
			 	view.getTrainingPanel().add(trainingExample);
			 	
			 	String nameTrainExample = JOptionPane.showInputDialog(null, "What is name of the Training Example ?", "Training Example's Name ", JOptionPane.QUESTION_MESSAGE);
			 	trainingEx = new TrainingExample(nameTrainExample,example);
			 	featureHead = trainingEx.getCompositeFeature();
			 	example.addTrainingExample(trainingEx);
			 	

			 	
		} else if (event.getActionCommand().equals("Create Testing Example")) {
			view.getTestFeature().setEnabled(true);
			 
		 	testingExample = new JList<>(example.getTestingExample());
		 	
		 	//add example to view list
		 	view.getTestingPanel().add(testingExample);
	
		 
		 	String nameTestExample = JOptionPane.showInputDialog(null, "What is name of the Testing Example ?", "Testing Example's Name ", JOptionPane.QUESTION_MESSAGE);

		    //testingEx = new TestingExample(example);
		    //testingEx.createExample(nameTestExample);
			//example.addTestingExample(testingEx);
			

	} else if (event.getActionCommand().equals("Add Training Feature")) {
		    view.getFeatureTrainEdit().setEnabled(true);
		        
		    int i = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to add the feature ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
		    trainingEx = example.getTrainingExampleIndex(i);
		    
		   /*
		    trainingEx.setFeatures(Option(trainingEx.getCompositeFeature()));
		    */
		    
		    
		    CompositeFeature temp =trainingEx.getCompositeFeature();
		    
		    trainingEx.setFeatures(Option(temp));
		    
		    
		 	//featureType = JOptionPane.showInputDialog(null, "Choose the option you would like for this feature(0 to exit, 1 for String, 2 for float, 3 for composite feature and 4 to go into a composite feature) ?", " Feature's Type ", JOptionPane.QUESTION_MESSAGE);
		 
		    	//addTrainFeature(featureName,featureType);
		    
		
		 
	}
	}/*	
		}else if (event.getActionCommand().equals("Add Testing Feature")) {
			 view.getFeatureTestEdit().setEnabled(true);
			 view.getCalculateError().setEnabled(true); 

	         int i = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to add the feature ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
	         testingEx = example.getTestingExampleIndex(i);
	         
	         askTestFeature();
	      
	      	//If feature type is complex enters loop
		 	while(featureType.equals(3)) {
		 		askTestFeature();
		 	}
		 	
	}else if (event.getActionCommand().equals("Edit Training Feature")) {
			
	
		int prevFeatureName = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to edit the feature ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
        trainingEx = example.getTrainingExampleIndex(prevFeatureName);
		String editFeatureName = JOptionPane.showInputDialog(null, "What is the name of the feature you want to edit?", " Feature's name ", JOptionPane.QUESTION_MESSAGE);

        trainingEx.getAllFeatures().get(editFeatureName); 
			
		 	String featureType = JOptionPane.showInputDialog(null, "What is the type of the Feature you would like to be editted (1 for String, 2 for float and 3 for complex ?", " Feature's Type to be editted ", JOptionPane.QUESTION_MESSAGE);
		 	
		 	if(featureType.equals("1")) {
		 		String featureSValue = JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE);
		 		trainingEx.editFeature(editFeatureName, new Feature(featureSValue));
			 	
		 	}
		 	
		 	if(featureType.equals("2")) {
		 		float featureIValue = Float.parseFloat(JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
		 		trainingEx.editFeature(editFeatureName, new Feature(featureIValue));
		 		
		 	}
		 	 	

		} else if (event.getActionCommand().equals("Edit Testing Feature")) {
			
	
		int prevFeatureName = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to edit the feature ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
        testingEx = example.getTestingExampleIndex(prevFeatureName);
		String editFeatureName = JOptionPane.showInputDialog(null, "What is the name of the feature you want to edit?", " Feature's name ", JOptionPane.QUESTION_MESSAGE);

		testingEx.getAllFeatures().get(editFeatureName);
        
			
		 	String featureType = JOptionPane.showInputDialog(null, "What is the type of the Feature you would like to be editted (1 for String, 2 for float, and 3 for complex ?", " Feature's Type to be editted ", JOptionPane.QUESTION_MESSAGE);
		 	
		 	if(featureType.equals("1")) {
		 		String featureSValue = JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE);
		 		testingEx.editFeature(editFeatureName, new Feature(featureSValue));
			 	
		 	}
		 	
		 	if(featureType.equals("2")) {
		 		float featureIValue = Float.parseFloat(JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
		 		testingEx.editFeature(editFeatureName, new Feature(featureIValue));
		 		
		 	}
		 	
		 	
		 	

		} else if (event.getActionCommand().equals("Predict")) {
			 
			
			distanceMetrics=new HashMap<String, String>();
			String testFeatureName = JOptionPane.showInputDialog(null, "What is name of the Feature you would like to predict?", " Feature's Name to be predicted", JOptionPane.QUESTION_MESSAGE);
		 	int knn = Integer.parseInt(JOptionPane.showInputDialog(null, "How many K-Nearest-Neighbours would you like to use?", " KNN Value ", JOptionPane.QUESTION_MESSAGE));
		 
		    for (String fName: testingEx.getAllFeatures().keySet()) {
			String metricType = JOptionPane.showInputDialog(null, "Which distance metric would you like to use for feature: ?" + fName, "Distance Metric", JOptionPane.QUESTION_MESSAGE);
		 	
		 	distanceMetrics.put(fName, metricType);
		 	}
		 	
		    testingEx.predictFeature(testFeatureName, knn, distanceMetrics);		
		}
	else if (event.getActionCommand().equals("CalculateError")) {
			
			String errorFeatureName = JOptionPane.showInputDialog(null, "What is the name of the feature you want to calculate the error for?", " Feature's name ", JOptionPane.QUESTION_MESSAGE);
			
			int prevFeatureName = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to calculate the error ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
	        trainingEx = example.getTestingExampleIndex(prevFeatureName);
			int knn = Integer.parseInt(JOptionPane.showInputDialog(null, "How many K-Nearest-Neighbours are there?", " KNN Value ", JOptionPane.QUESTION_MESSAGE));
			float error = example.calculateError(trainingEx, trainingEx.getAllFeatures().get(errorFeatureName), knn);
			
			JOptionPane.showMessageDialog(view,"Error is: " + error);
			
				
		}else if (event.getActionCommand().equals("Save Training Example")) {
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("TrainingExamples.txt"));
				out.write(trainingExample.toString());
				out.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}else if (event.getActionCommand().equals("Save Testing Example")) {
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("TestingExamples.txt"));
				out.write(testingExample.toString());
				out.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		} else if (event.getActionCommand().equals("Restart")) {
			new KNNView();
		} 

	}

/**
 * Method which prints the training example routine output
 * */
	
	public String ask() {
		 return JOptionPane.showInputDialog(null, "What is name of the Feature you would like to be added ?", " Feature's Name ", JOptionPane.QUESTION_MESSAGE);		 	
	}
	
	public CompositeFeature Option(CompositeFeature currentComposite) {
		
		newCurrent = currentComposite;
	 	//boolean flag = 
		 featureType = JOptionPane.showInputDialog(null, "Choose the option you would like for this feature(0 to exit, 1 for String, 2 for float, 3 for composite and 4 to go into a composite feature) ?", " Feature's Type ", JOptionPane.QUESTION_MESSAGE);

	   
	
		 if(featureType.equals("1") ) {
		 	String name = ask();
	 		 featureSValue = JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE);	
	 		 StringFeature temp= new StringFeature(name, featureSValue);
		 	 newCurrent.addFeature(temp);
	 		 //trainingEx.addStringFeature(featureName,featureSValue,newCurrent);
		 	 
	 	}else if(featureType.equals("2")){	
	 		String name = ask();
	 		featureFValue = Float.parseFloat(JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
	 		 FloatFeature temp= new FloatFeature(name, featureFValue);
		 	 newCurrent.addFeature(temp);
	 		//trainingEx.addFloatFeature(featureName,featureFValue,newCurrent);
	 	}else if(featureType.equals("3")){
	 		String name = ask();
	 		CompositeFeature temp = new CompositeFeature(name);
	 		newCurrent.addFeature(temp);
	 		//trainingEx.addCompositeFeature(featureName,trainingEx.getCompositeFeature());
	 		//featureFValue = Integer.parseInt(JOptionPane.showInputDialog(null, "Would you like to add another composite feature ?", " Composite Feature ", JOptionPane.QUESTION_MESSAGE));
	 		 //trainingEx.addCompositeFeature(featureName,newCurrent);
	 	}else if(featureType.equals("4")) {
	 		String compName = JOptionPane.showInputDialog(null, "What is name of the Composite that you would like to jump inside ?", " Composites Name ", JOptionPane.QUESTION_MESSAGE);	
	 		newCurrent = jumpIn(compName,newCurrent);
	 	}else if(featureType.equals("5")) {	
	 		newCurrent = newCurrent.getParent();
	 	}else if(featureType.equals("0")) {
	 		newCurrent = getToHead(newCurrent);
	 		return newCurrent;
	 	}
		newCurrent=Option(newCurrent);
		return newCurrent;
	}
	public CompositeFeature jumpIn(String compositeName,CompositeFeature currentFeature) {
		CompositeFeature newCurrent;
		for(int i=0;i<currentFeature.getSubFeatureSize();i++) {
			if(currentFeature.getSubFeature(i).getFName().equals(compositeName) && currentFeature.getSubFeature(i) instanceof CompositeFeature) {
				newCurrent = (CompositeFeature)currentFeature.getSubFeature(i);
				return newCurrent;
			}
		}
		return null;
	}	

/**
 * Method which prints the Testing example routine output
 * */
	public void askTestFeature(CompositeFeature current) {
	    featureName = JOptionPane.showInputDialog(null, "What is name of the Feature you would like to be added ?", " Feature's Name ", JOptionPane.QUESTION_MESSAGE);
	 	featureType = JOptionPane.showInputDialog(null, "Choose the option you would like for this feature(1 for String, 2 for float, 3 for complex and 4 to go into a composite feature) ?", " Feature's Type ", JOptionPane.QUESTION_MESSAGE);
		
	 	if(featureType.equals("1")) {
	 		featureSValue = JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE);
	 	//addStringFeature("Color","red",head);
	 	//	testingEx.addStringFeature(featureName, );
	 	
	 	}
	 	
	 	if(featureType.equals("2")) {
	 		featureFValue = Float.parseFloat(JOptionPane.showInputDialog(null, "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
	 		//testingEx.addFeature(featureName, new Feature(featureFValue));
	 		
	 	}
	}
	public CompositeFeature getToHead(CompositeFeature current) {
		CompositeFeature newCurrent = current;
		if(current.getFName().equals("head")) {
			//newCurrent = current.getParent();
			return newCurrent;
		}else {
			newCurrent = current.getParent();
			return getToHead(newCurrent);
		}
	}
}

