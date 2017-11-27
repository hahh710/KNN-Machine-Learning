import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @variables
 * -exampleName : String : It holds the name of the TrainingExample.
 * -feature :HashMap<String,Feature> : in Hashmap, it will hold Key : name of type of the Features, Value : feature  
 * -nameSet :DefaultListModel<String> : This contains all the names of type of the feature.
 * @Method
 * +addFeature(String keyname,Feature value) : adding feature with type of the fature in hashmap.
 * +getFeature(String keyname) : feature : getter for the Feature using keyname
 * +removeFeature(String keyname) : remove the feature from the hash map
 * +getExampleName() : String : getter for name of the Training example 
 * +editFeature(String keyname, Feature value) : editing the Feature with other feature. 
 * +editExampleName(String name) : editing the examplename.
 * +checkKeyName(String keyname) : boolean : it returns true or false, if hashmap contains the key. 
 * +getKeyName(Feature value) : String : getter for key from the hashmap.  
 * +getNameSet() : DefaultListModel<String> : it returns DefaultListmodel of String containing all the name of key.
 * +getAllFeatures() : HashMap<String,Feature> : it return the hash map for all the features.
 * +setFeatures(HashMap<String, Feature> h) : setter for hashmap features.
 * +getTrainingExampleName() : String : getter for Training Example Name;
 * +setTrainingExampleName(String name) : setter for TrainingExample name;
 * + toString() : String : it returns String containing all the feature name and feature type;
 *
 */


public class TrainingExample {
	private String exampleName;
	private Example manager;
	private CompositeFeature features; 
	private ArrayList<Feature> linearizedFeatures;
	private DefaultListModel<String>printFeatures;
	public TrainingExample() {
		exampleName=null;
		manager=null;
		features=null;
	}
	
	public TrainingExample(String name){
		//this.manager=manager;
		printFeatures = new DefaultListModel<String>();
		features = new CompositeFeature("head", "head");
		this.exampleName = name; 
	}
	public TrainingExample(String name, Example man){
		this.manager=man;
		printFeatures = new DefaultListModel<String>();
		features = new CompositeFeature("head", "head");
		this.exampleName = name; 
	}
	//public createFeatureType{
	//create feature type
	//public createFeatureType{
	//create feature type
	//

	public DefaultListModel<String> getPrintFeatures(){
		printFeatures.addElement(toString());
		return printFeatures;
	}
	
	public String getTrainingExampleName(){
		return exampleName;
	}
	public void setTrainingExampleName(String name){
		exampleName = name;
	}
	
	public CompositeFeature addStringFeature(String fName,String value,CompositeFeature  currentFeature) {
		StringFeature sFeature = new StringFeature(fName,value, currentFeature.getStringID());
		currentFeature.addFeature(sFeature);
		return currentFeature;
	}
	//2
	public CompositeFeature addFloatFeature(String fName,Float value,CompositeFeature currentFeature) {
		FloatFeature fFeature = new FloatFeature(fName,value, currentFeature.getStringID());
		currentFeature.addFeature(fFeature);
		return currentFeature;
	}
	//
	//3
	public CompositeFeature addCompositeFeature(String compositeName,CompositeFeature currentFeature) {
		CompositeFeature comp = new CompositeFeature(compositeName, currentFeature.getStringID());
		currentFeature.addFeature(comp);
		return currentFeature;
	}
	//case4
	//
	public Feature getFeature(String s) {
		for (Feature f: features.getSubFeatures()) {
			if (f.getFName().equals(s)) {
				return f;
			}
			if(f instanceof CompositeFeature) {
				return getFeature(s);
			}
		}
		return null;
	}
	public ArrayList<Feature> linearizeFeatures(ArrayList<Feature> list){
		for (Feature f: features.getSubFeatures()) {
			list.add(f);
			if(f instanceof CompositeFeature) {
				linearizeFeatures(list);
			}
		}
		return list;
	}
	public CompositeFeature jumpIn(String compositeName,CompositeFeature currentFeature) throws IOException{
		CompositeFeature newCurrent;
		for(int i=0;i<features.getSubFeatureSize();i++) {
			if(features.getSubFeature(i).getFName().equals(compositeName) && features.getSubFeature(i) instanceof CompositeFeature) {
				newCurrent = (CompositeFeature)features.getSubFeature(i);
				return newCurrent;
			}
		}
		return null;
	}	
	/**
	public void option(CompositeFeature head) throws IOException{
		String f = "";
		CompositeFeature newwCurrent;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("what u want option");
		String s = br.readLine();
		
		//if user choose 1 or 2 creating String Feature or Float Feature.
		while(!s.equals("0")) {
			if(s.equals("1")){
				
				System.out.println("in 1");
				
				addStringFeature("Color","red",head);
				f=features.toString();
				System.out.println(f);
				s = br.readLine();
				
			}else if(s.equals("2")) {
				System.out.println("in 2");
				addFloatFeature("distance",(float)2.2,head);
				System.out.println(features.toString());
				s = br.readLine();
			}else if(s.equals("3")) { //if user choose 3 then creating composite Feature.
				System.out.println("in 3");
				addCompositeFeature("Ball",head);
				System.out.println(features.toString());
				s = br.readLine();
			}else if(s.equals("4")) { //if user choose 4 then go inside of composite Feature. 
				System.out.println("in 4");
				BufferedReader cr = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("what u name Ball");
				String t = cr.readLine();
				//CompositeFeature newwCurrent;
				newwCurrent = jumpIn(t,head);
				option(newwCurrent);
			}
		}
		*/
		//if this keyname exists then
		/**
		 * if(f instanceof CompositeFeature){
		 *	What feature would you like to add to this composite
		 *	now you have newFeature
		 *	addFeature(newFeature)
		 *}
		 *
		 *
		 * }
		 */
		
	
	public CompositeFeature getFeatures() {
		return features;
	}
	public void setFeatures(CompositeFeature features) {
		this.features = features;
	}
	public CompositeFeature getCompositeFeature() {
		return this.features;
	}
	public Example getManager() {
		return manager;
	}

	/*
			if(!features.contains(f)) {
				features.add( f);
			}else{
				System.out.println("There is same name of feature");// print this statement in 
			}*/
/*
	public void removeFeature(String fName){
		for(Feature feature: features) {
			if(feature.getFName().equals(fName))
				features.remove(feature);
		}
	}
	public Feature getFeature(String f){
		for(Feature feature: features) {
			if(feature.getFName().equals(f))
				return feature;
		}
		return null;
	}
	public String getName(){
		return name;
	}
	public void setName(String f){ 
		name = f;
	}

	public ArrayList<Feature> getFeatures(){
		return features;
	}

	public String toString(){
		String tostring = exampleName + ": ";
		for(int i =0;i < nameSet.size(); i++){
			tostring += nameSet.get(i) + " = " + feature.get(nameSet.get(i)).toString()+ "," + "\n" ;
		}
		return tostring;
	}*/
	public String toString(){
		String tostring = exampleName + ": ";
		tostring=tostring+ features.toString();
		return tostring;
	}
}
