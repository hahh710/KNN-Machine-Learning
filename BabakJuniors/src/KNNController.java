import java.awt.event.*;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.io.PrintWriter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
public class KNNController implements ActionListener,Serializable{

	private KNNView view;
	private JList<TestingExample> testingExample;
	private JList <TrainingExample> trainingExample;
	private ArrayList<TrainingExample> trainEx;
	private Example example;
	private TestingExample testingEx;
	private TrainingExample trainingEx;
	private HashMap <String, String> distanceMetrics;
	private String featureName;
	private String featureType;
	private String featureSValue,name;
	private float featureFValue;
	private String pridictedPath;
	private CompositeFeature featureHead;
	private CompositeFeature newCurrent;
	private ArrayList<Feature> linearizedFeaturestest = new ArrayList<Feature>();
	private Feature path;
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
			/**
			 * Prompt the user the exact same way as addfeature
			 * addFeature(Name, null);
			 */int i = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to add the feature ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
			 testingEx = example.getTestingExampleIndex(i);

			 CompositeFeature temp1 = testingEx.getCompositeFeature();
			 CompositeFeature pridict = predictOption(temp1);
			
			 testingEx.setFeatures(pridict);
			 //String testFeatureName = JOptionPane.showInputDialog(null, "What is name of the Feature you would like to predict?"+"\n"+"(If you would like to predict a feature inside a composite type ->) For example t1: Ball(Distance( colour: red,): Type in Ball->Distance->colour to predict the colour in testing", " Feature's Name to be predicted", JOptionPane.QUESTION_MESSAGE);
			 //String predictfeatureType;

			 //String testFeatureName = JOptionPane.showInputDialog(null, "What is name of the Feature you would like to predict?"+"\n"+"(If you would like to predict a feature inside a composite type ->) For example t1: Ball(Distance( colour: red,): Type in Ball->Distance->colour to predict the colour in testing", " Feature's Name to be predicted", JOptionPane.QUESTION_MESSAGE);


			 Feature temp = testingEx.getFeature(pridictedPath);
			 JOptionPane.showMessageDialog(view,"Path for value to be to predicted is: " + pridictedPath);
			 int knn = Integer.parseInt(JOptionPane.showInputDialog(null, "How many K-Nearest-Neighbours would you like to use?", " KNN Value ", JOptionPane.QUESTION_MESSAGE));




			 //String Fname = trainingEx.getCompositeFeature().getSubFeature(1).getFName();
			 testingEx.setLini(linearizedFeaturestest);
			 //for (Feature f:trainingEx.linearizeFeatures() ) ;
			 testingEx.clearLinear();
			 ArrayList<Feature> smell= new ArrayList<Feature>();
			 testingEx.linearizeFeatures(testingEx.getFeatures());
			 for (Feature f:testingEx.getLinearalized() ) {
				 if(f instanceof FloatFeature){
					 String [] floatMetrics = {"absoluteDistance", "SquareDistance" };
					 String metricType = (String) JOptionPane.showInputDialog(null,  "Which distance metric would you like to use for float feature: "+ f.getFName()," Distance Metric", JOptionPane.QUESTION_MESSAGE, null,  floatMetrics, floatMetrics[0]);
					 distanceMetrics.put(f.getStringID("", f), metricType);	
				 } else if(f instanceof StringFeature){
					 String [] stringMetrics = {"commonletter", "sizeofstring", "lexGraphic" };
					 String metricType = (String) JOptionPane.showInputDialog(null,  "Which distance metric would you like to use for String feature: "+f.getFName(), "Distance Metric", JOptionPane.QUESTION_MESSAGE, null,  stringMetrics, stringMetrics[0]);
					 distanceMetrics.put(f.getStringID("", f), metricType);
				 }else if(f instanceof CompositeFeature){
					 String [] compositeMetrics = {"euclidean" };
					 String metricType = (String) JOptionPane.showInputDialog(null,  "Which distance metric would you like to use for Composite feature: "+f.getFName(),"Distance Metric", JOptionPane.QUESTION_MESSAGE, null,  compositeMetrics, compositeMetrics[0]);
					 distanceMetrics.put(f.getStringID("", f), metricType);
				 }

				 //String metricType = JOptionPane.showInputDialog(null, "Which distance metric would you like to use for feature: ?", "Distance Metric", JOptionPane.QUESTION_MESSAGE);
				 //distanceMetrics.put(f.getStringID("", f), metricType);
			 }
			 int errorKnn = knn -1;
			 if(knn == 1) {
				 errorKnn = 1; 
			 }
			 JOptionPane.showMessageDialog(view,"Prediction is: " +  testingEx.predictFeature(path, knn, distanceMetrics).toString() + "\n" + "Error is: " + testingEx.calculateError(path, errorKnn, distanceMetrics) + "%");

		}else if (event.getActionCommand().equals("Predict All")) {

			String errorFeatureName = JOptionPane.showInputDialog(null, "What is the name of the feature you want to calculate the error for?", " Feature's name ", JOptionPane.QUESTION_MESSAGE);

			int prevFeatureName = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the index at which you would like to calculate the error ?", " Feature's Index ", JOptionPane.QUESTION_MESSAGE));
			testingEx = example.getTestingExampleIndex(prevFeatureName);
			int k = Integer.parseInt(JOptionPane.showInputDialog(null, "How many K-Nearest-Neighbours are there?", " KNN Value ", JOptionPane.QUESTION_MESSAGE));
		
		}else if (event.getActionCommand().equals("Save Train Example")) {
		
			String contents = "";
			PrintWriter out = null;
			try {
				FileOutputStream fos = new FileOutputStream ("TrainingExample.o");
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream outO = new ObjectOutputStream(bos);
				outO.writeObject((DefaultListModel<TrainingExample>) example.getTrainingExamples());

				for (int i =0;i<example.getTrainingExample().size();i++) {
					outO.writeObject(example.getTrainingExampleIndex(i));

				}
				outO.close();
			}catch (IOException e1) {
				
				e1.printStackTrace();
			}
			try {
				out = new PrintWriter("TrainingExample.txt");
				for(int i = 1 ; i < example.getTrainingExample().size() + 1;i++)
				{
					contents = example.getTrainingExampleIndex(i-1).toString();
					out.println(contents);
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}

			out.close();
		


		}else if (event.getActionCommand().equals("Save Test Example")) {
			String contents = "";
			PrintWriter out = null;
			try {
				FileOutputStream fos = new FileOutputStream ("TestingExample.o");
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream outO = new ObjectOutputStream(bos);
				outO.writeObject((DefaultListModel<TestingExample>) example.getTestingExample());

				for (int i =0;i<example.getTestingExample().size();i++) {
					outO.writeObject(example.getTestingExampleIndex(i));

				}
				outO.close();
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				out = new PrintWriter("TestingExample.txt");
				for(int i = 1 ; i < example.getTestingExample().size() + 1;i++)
				{
					contents = example.getTestingExampleIndex(i-1).toString();
					out.println(contents);
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			out.close();

		} else if (event.getActionCommand().equals("Restart")) {
			new KNNView();
		} else if (event.getActionCommand().equals("Load Training Example")){

			String fileName = JOptionPane.showInputDialog(null, "What is the name of the file(.0) that you want to load (except .0)", " Import", JOptionPane.QUESTION_MESSAGE);
			fileName += ".o";
			DefaultListModel<TrainingExample> training = null;
			try{
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
				training = (DefaultListModel<TrainingExample>) ois.readObject();
				//System.out.println("Object: " + training);//ois.readObject());

				//System.out.println("" + ois.readObject());
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			view.getFeatureTrainEdit().setEnabled(true);
			view.getTrainFeature().setEnabled(true);

			trainingExample = new JList<>(example.getTrainingExample()); 	
			view.getTrainingPanel().add(trainingExample);

			for(int i=0 ; i<training.size();i++) {
				example.addTrainingExample((TrainingExample)training.getElementAt(i));
			}
			//example.setTrainingExamples(training);

		}
		else if (event.getActionCommand().equals("Load Testing Example")){
			//load
			String fileName = JOptionPane.showInputDialog(null, "What is the name of the file that you want to load (don't type file type)", " Import", JOptionPane.QUESTION_MESSAGE);
			fileName += ".o";
			DefaultListModel<TestingExample> testing = null;
			try{
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
				testing = (DefaultListModel<TestingExample>) ois.readObject();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			view.getTestFeature().setEnabled(true);

			testingExample = new JList<>(example.getTestingExample());

			//add example to view list
			view.getTestingPanel().add(testingExample);

			for(int i=0 ; i<testing.size();i++) {
				example.addTestingExample((TestingExample)testing.getElementAt(i));
			}
		}
	}

	/**
	 * Method which prints the training example routine output
	 * */
	public String ask() {
		return JOptionPane.showInputDialog(null, "What is name of the Feature you would like to be added ?", " Feature's Name ", JOptionPane.QUESTION_MESSAGE);		 	
	}

	public String predictAsk() {
		String temp = JOptionPane.showInputDialog(null, "What is name of the Feature you would like to predict?", " Feature's Name ", JOptionPane.QUESTION_MESSAGE);
		return temp;		 	
	}
	public String ask(CompositeFeature currentComposite) {
		String name =  JOptionPane.showInputDialog(null, "What is name of the Feature you would like to be added ?", " Feature's Name ", JOptionPane.QUESTION_MESSAGE);	
		if (currentComposite.checkSameFeatureName(name)) {

			JOptionPane.showMessageDialog(view,"There is same name of Feature Try again.");
			return ask(currentComposite);
		}else {

			return name;
		}
	}

	public CompositeFeature Option(CompositeFeature currentComposite) {

		newCurrent = currentComposite;
		String path = "";
		path = path(path,newCurrent);
		featureType = JOptionPane.showInputDialog(null,path +"\n"+"Choose the option you would like for this feature(0 to exit, 1 for String, 2 for float, 3 for composite and 4 to go into a composite feature and 5 to jump out of the current composite) ?", " Feature's Type ", JOptionPane.QUESTION_MESSAGE);



		if(featureType.equals("1") ) {

			String name = ask(currentComposite);
			featureSValue = JOptionPane.showInputDialog(null,path +"\n"+ "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE);	
			//path = newCurrent.getStringID(path,newCurrent.getParent());
			StringFeature temp= new StringFeature(name, featureSValue );
			newCurrent.addFeature(temp);


		}else if(featureType.equals("2")){	
			String name = ask(currentComposite);
			featureFValue = Float.parseFloat(JOptionPane.showInputDialog(null,path +"\n"+ "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
			FloatFeature temp= new FloatFeature(name, featureFValue);
			newCurrent.addFeature(temp);

		}else if(featureType.equals("3")){
			String name = ask(currentComposite);
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
			String name = ask(currentComposite);
			featureSValue = JOptionPane.showInputDialog(null,path +"\n"+ "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE);	
			//path = newCurrent.getStringID(path,newCurrent.getParent());
			StringFeature temp= new StringFeature(name, featureSValue );
			linearizedFeaturestest.add(temp);
			newCurrent.addFeature(temp);


		}else if(featureType.equals("2")){	
			String name = ask(currentComposite);
			featureFValue = Float.parseFloat(JOptionPane.showInputDialog(null,path +"\n"+ "What is value of the Feature you would like to be added ?", " Feature's Value ", JOptionPane.QUESTION_MESSAGE));
			FloatFeature temp= new FloatFeature(name, featureFValue);
			linearizedFeaturestest.add(temp);
			newCurrent.addFeature(temp);

		}else if(featureType.equals("3")){
			String name = ask(currentComposite);
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
					String set = JOptionPane.showInputDialog(null,path +"\n"+ "What is the feature name of this composite that you would like to change to?", " Value ", JOptionPane.QUESTION_MESSAGE);
					currentComposite.getSubFeature(i).setFName(set);

					//newCurrent=editOption(newCurrent);
					newCurrent = currentComposite;
					//break;

				}else if(featureType.equals(currentComposite.getSubFeature(i).getFName()) && currentComposite.getSubFeature(i) instanceof FloatFeature) {
					String fname = JOptionPane.showInputDialog(null,path +"\n"+ "What is the feature name of  that you would like to change to?", " Value ", JOptionPane.QUESTION_MESSAGE);
					currentComposite.getSubFeature(i).setFName(fname);
					Float set = Float.parseFloat(JOptionPane.showInputDialog(null,path +"\n"+ "What is the value that you would like it change to?", " Value ", JOptionPane.QUESTION_MESSAGE));
					FloatFeature temp = (FloatFeature)currentComposite.getSubFeature(i);
					temp.setValue(set);
					currentComposite.getSubFeatures().set(i, temp);
					//newCurrent=editOption(newCurrent);
					//break;
					newCurrent = currentComposite;
					//currentComposite.getSubFeature(i).setFName(set);
				}else if(featureType.equals(currentComposite.getSubFeature(i).getFName()) && currentComposite.getSubFeature(i) instanceof StringFeature) {
					String fname = JOptionPane.showInputDialog(null,path +"\n"+ "What is the feature name of that you would like it change to?", " Value ", JOptionPane.QUESTION_MESSAGE);
					currentComposite.getSubFeature(i).setFName(fname);
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
	}
	public CompositeFeature predictOption(CompositeFeature currentComposite) {
		newCurrent = currentComposite;
		pridictedPath = "";
		pridictedPath = path(pridictedPath,newCurrent);
		
		featureType = JOptionPane.showInputDialog(null,pridictedPath +"\n"+"Choose the type for the feature you want to predict(1 for String, 2 for float, 3 for composite and 4 to go into a composite feature and 5 to jump out of the current composite) ?", " Feature's Type ", JOptionPane.QUESTION_MESSAGE);



		if(featureType.equals("1") ) {
			String name = predictAsk();
			StringFeature temp= new StringFeature(name, null );
			path = temp;
			pridictedPath = pridictedPath + name;
			newCurrent.addFeature(temp);
			

		}else if(featureType.equals("2")){	
			String name = predictAsk();
			FloatFeature temp= new FloatFeature(name);
			path = temp;
			pridictedPath = pridictedPath + name;
			newCurrent.addFeature(temp);
			

		}else if(featureType.equals("3")){
			String name = predictAsk();
			CompositeFeature temp = new CompositeFeature(name);
			path = temp;
			pridictedPath = pridictedPath + name;
			newCurrent.addFeature(temp);
			

		}else if(featureType.equals("4")) {
			String compName = JOptionPane.showInputDialog(null,pridictedPath +"\n"+ "What is name of the Composite that you would like to jump inside ?", " Composites Name ", JOptionPane.QUESTION_MESSAGE);	
			newCurrent = jumpIn(compName,newCurrent);

		}else if(featureType.equals("5")) {	
			newCurrent = newCurrent.getParent();
		}
		//newCurrent=Option(newCurrent);
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

