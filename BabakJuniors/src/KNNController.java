import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
	private ArrayList<Feature> linearizedFeaturestest = new ArrayList<Feature>();

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

			testingEx = new TestingExample(nameTestExample,example);
			example.addTestingExample(testingEx);

		} else if (event.getActionCommand().equals("Add Training Feature")) {
			view.getTrainSave().setEnabled(true);
			view.getFeatureTrainEdit().setEnabled(true);

			int i = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to add the feature ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
			trainingEx = example.getTrainingExampleIndex(i);

			CompositeFeature temp = trainingEx.getCompositeFeature();

			trainingEx.setFeatures(Option(temp));

		}else if (event.getActionCommand().equals("Add Testing Feature")) {
			view.getTestSave().setEnabled(true);
			view.getFeatureTestEdit().setEnabled(true);
			view.getCalculateError().setEnabled(true); 

			int i = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to add the feature ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
			testingEx = example.getTestingExampleIndex(i);

			CompositeFeature temp = testingEx.getCompositeFeature();
			testingEx.setFeatures(OptionTest(temp));

		
	}else if (event.getActionCommand().equals("Edit Training Feature")) {


		int prevFeatureName = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to edit the feature ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
		trainingEx = example.getTrainingExampleIndex(prevFeatureName);
		CompositeFeature temp = trainingEx.getCompositeFeature();
		temp = editOption(temp);
		trainingEx.setFeatures(temp);
		



	} else if (event.getActionCommand().equals("Edit Testing Feature")) {


		int prevFeatureName = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to edit the feature ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
		testingEx = example.getTestingExampleIndex(prevFeatureName);

		CompositeFeature temp = testingEx.getCompositeFeature();
		temp = editOption(temp);
		testingEx.setFeatures(temp);


	
	
	}else if (event.getActionCommand().equals("Predict")) {


		distanceMetrics=new HashMap<String, String>();
		String testFeatureName = JOptionPane.showInputDialog(null, "What is name of the Feature you would like to predict?"+"\n"+"(If you would like to predict a feature inside a composite type ->) For example t1: Ball(Distance( colour: red,): Type in Ball->Distance->colour to predict the colour in testing", " Feature's Name to be predicted", JOptionPane.QUESTION_MESSAGE);
		
		
		Feature temp = testingEx.getFeature(testFeatureName);
		JOptionPane.showMessageDialog(view,"Prediction is: " + testFeatureName);
		int knn = Integer.parseInt(JOptionPane.showInputDialog(null, "How many K-Nearest-Neighbours would you like to use?", " KNN Value ", JOptionPane.QUESTION_MESSAGE));

		
		
		//String Fname = trainingEx.getCompositeFeature().getSubFeature(1).getFName();
		testingEx.setLini(linearizedFeaturestest);
		//for (Feature f:trainingEx.linearizeFeatures() ) ;
		for (Feature f:testingEx.linearizeFeatures() ) {
			
			String metricType = JOptionPane.showInputDialog(null, "Which distance metric would you like to use for feature: ?", "Distance Metric", JOptionPane.QUESTION_MESSAGE);
			distanceMetrics.put(f.getStringID("", f), metricType);
		}

		
		JOptionPane.showMessageDialog(view,"Prediction is: " +  testingEx.predictFeature(temp, knn, distanceMetrics).toString());

	}else if (event.getActionCommand().equals("CalculateError")) {

		String errorFeatureName = JOptionPane.showInputDialog(null, "What is the name of the feature you want to calculate the error for?", " Feature's name ", JOptionPane.QUESTION_MESSAGE);

		int prevFeatureName = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to calculate the error ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
		trainingEx = example.getTestingExampleIndex(prevFeatureName);
		int knn = Integer.parseInt(JOptionPane.showInputDialog(null, "How many K-Nearest-Neighbours are there?", " KNN Value ", JOptionPane.QUESTION_MESSAGE));
		//float error = example.calculateError(trainingEx, trainingEx.getAllFeatures().get(errorFeatureName), knn);

		//JOptionPane.showMessageDialog(view,"Error is: " + error);


	}else if (event.getActionCommand().equals("Save Train Example")) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("TrainingExamples.txt"));
			out.write(trainingEx.toString());
			out.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		
		try {
			FileOutputStream out = new FileOutputStream("objectTrainingExample.txt");
			ObjectOutputStream oout = new ObjectOutputStream(out);
			
				oout.writeObject(trainingEx.toString());
				out.close();
			
			
		} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
	}else if (event.getActionCommand().equals("Save Test Example")) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("TestingExamples.txt"));
			out.write(testingEx.toString());
			out.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		
		
		try {
			FileOutputStream out = new FileOutputStream("objectTestingExample.txt");
			ObjectOutputStream oout = new ObjectOutputStream(out);
			
				oout.writeObject(testingEx.toString());
				out.close();
			
			
		} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
	

	} else if (event.getActionCommand().equals("Restart")) {
		new KNNView();
	} else if (event.getActionCommand().equals("Load Training Example")){
		//load
	}
	else if (event.getActionCommand().equals("Load Testing Example")){
		//load
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
		String path = "";
		path = path(path,newCurrent);
		featureType = JOptionPane.showInputDialog(null,path +"\n"+"Choose the option you would like for this feature(0 to exit, 1 for String, 2 for float, 3 for composite and 4 to go into a composite feature and 5 to jump out of the current composite) ?", " Feature's Type ", JOptionPane.QUESTION_MESSAGE);



		if(featureType.equals("1") ) {
			String name = ask();
			featureSValue = JOptionPane.showInputDialog(null,path +"\n"+ "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE);	
			//path = newCurrent.getStringID(path,newCurrent.getParent());
			StringFeature temp= new StringFeature(name, featureSValue );
			newCurrent.addFeature(temp);


		}else if(featureType.equals("2")){	
			String name = ask();
			featureFValue = Float.parseFloat(JOptionPane.showInputDialog(null,path +"\n"+ "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
			FloatFeature temp= new FloatFeature(name, featureFValue);
			newCurrent.addFeature(temp);

		}else if(featureType.equals("3")){
			String name = ask();
			CompositeFeature temp = new CompositeFeature(name);
			newCurrent.addFeature(temp);
		}else if(featureType.equals("4")) {
			String compName = JOptionPane.showInputDialog(null,path +"\n"+ "What is name of the Composite that you would like to jump inside ?", " Composites Name ", JOptionPane.QUESTION_MESSAGE);	
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
	public CompositeFeature OptionTest(CompositeFeature currentComposite) {

		newCurrent = currentComposite;
		String path = "";
		path = path(path,newCurrent);
		featureType = JOptionPane.showInputDialog(null,path +"\n"+"Choose the option you would like for this feature(0 to exit, 1 for String, 2 for float, 3 for composite and 4 to go into a composite feature and 5 to jump out of the current composite) ?", " Feature's Type ", JOptionPane.QUESTION_MESSAGE);



		if(featureType.equals("1") ) {
			String name = ask();
			featureSValue = JOptionPane.showInputDialog(null,path +"\n"+ "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE);	
			//path = newCurrent.getStringID(path,newCurrent.getParent());
			StringFeature temp= new StringFeature(name, featureSValue );
			linearizedFeaturestest.add(temp);
			newCurrent.addFeature(temp);


		}else if(featureType.equals("2")){	
			String name = ask();
			featureFValue = Float.parseFloat(JOptionPane.showInputDialog(null,path +"\n"+ "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
			FloatFeature temp= new FloatFeature(name, featureFValue);
			linearizedFeaturestest.add(temp);
			newCurrent.addFeature(temp);

		}else if(featureType.equals("3")){
			String name = ask();
			CompositeFeature temp = new CompositeFeature(name);
			linearizedFeaturestest.add(temp);
			newCurrent.addFeature(temp);
		}else if(featureType.equals("4")) {
			String compName = JOptionPane.showInputDialog(null,path +"\n"+ "What is name of the Composite that you would like to jump inside ?", " Composites Name ", JOptionPane.QUESTION_MESSAGE);	
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

	public CompositeFeature editOption(CompositeFeature currentComposite) {

		newCurrent = currentComposite;
		String path = "";
		path = path(path,newCurrent);

		featureType = JOptionPane.showInputDialog(null,path +"\n"+ "Whats the feature name you would like to edit?" + "\n" +" If feature is inside a composite please jump in by typing 4 ", " Feature's Type ", JOptionPane.QUESTION_MESSAGE);



		if(featureType.equals("4")) {
			String compName = JOptionPane.showInputDialog(null,path +"\n"+ "What is name of the Composite that you would like to jump inside ?", " Composites Name ", JOptionPane.QUESTION_MESSAGE);	
			newCurrent = jumpIn(compName,newCurrent);
			return editOption(newCurrent);
		}else if(featureType.equals("0")) {
			newCurrent = getToHead(newCurrent);
			return newCurrent;
		}else {
			for(int i =0;i<currentComposite.getSubFeatureSize();i++) {
				if(featureType.equals(currentComposite.getSubFeature(i).getFName()) && currentComposite.getSubFeature(i) instanceof CompositeFeature) {
					String set = JOptionPane.showInputDialog(null,path +"\n"+ "What is the value that you would like to change to?", " Value ", JOptionPane.QUESTION_MESSAGE);
					currentComposite.getSubFeature(i).setFName(set);

					//newCurrent=editOption(newCurrent);
					newCurrent = currentComposite;
					//break;

				}else if(featureType.equals(currentComposite.getSubFeature(i).getFName()) && currentComposite.getSubFeature(i) instanceof FloatFeature) {
					Float set = Float.parseFloat(JOptionPane.showInputDialog(null,path +"\n"+ "What is the value that you would like to change to?", " Value ", JOptionPane.QUESTION_MESSAGE));
					FloatFeature temp = (FloatFeature)currentComposite.getSubFeature(i);
					temp.setValue(set);
					currentComposite.getSubFeatures().set(i, temp);
					//newCurrent=editOption(newCurrent);
					//break;
					newCurrent = currentComposite;
					//currentComposite.getSubFeature(i).setFName(set);
				}else if(featureType.equals(currentComposite.getSubFeature(i).getFName()) && currentComposite.getSubFeature(i) instanceof StringFeature) {
					String set = JOptionPane.showInputDialog(null,path +"\n"+ "What is the value that you would like to change to?", " Value ", JOptionPane.QUESTION_MESSAGE);
					StringFeature temp = (StringFeature)currentComposite.getSubFeature(i);
					temp.setfValue(set);
					currentComposite.getSubFeatures().set(i, temp);
					//newCurrent=editOption(newCurrent);
					newCurrent = currentComposite;
				}
			}
			newCurrent = getToHead(newCurrent);
			return newCurrent;
		}
		//return newCurrent;
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
	public String path(String path,CompositeFeature current) {
		CompositeFeature newCurrent = current;
		if(current.getFName().equals("head")) {
			path = "Head->"+ path ;  //t.getTrainingExampleName();
			return path;
		}else {
			path = current.getFName() +"->" + path;
			newCurrent = current.getParent();
			return path(path,newCurrent);
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

