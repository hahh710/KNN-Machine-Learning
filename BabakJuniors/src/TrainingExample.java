import java.util.HashMap;

import javax.swing.DefaultListModel;
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
	private HashMap<String,Feature> feature; 
	private DefaultListModel<String>nameSet;

	public TrainingExample(){
		exampleName = null;
	}

	public void createExample(String name){
		this.exampleName = name;
		feature = new HashMap<String,Feature>();
		nameSet = new DefaultListModel<String>();
	}
	//public createFeatureType{
	//create feature type
	public void addFeature(String keyname,Feature value){
		//if this keyname exists then
		if(!feature.containsKey(keyname)) {
			
			feature.put(keyname, value);
			feature.get(keyname).setFName(keyname);
			nameSet.addElement(keyname);
		}else{
			System.out.println("There is same name of feature");// print this statement in 
		}
		
	}
	public Feature getFeature(String keyname){
		return feature.get(keyname);
	}
	public void removeFeature(String keyname){
		feature.remove(keyname);
	}
	public String getExampleName(){
		return exampleName;
	}
	public void editFeature(String keyname, Feature value){
		feature.replace(keyname, value);
	}
	public void editExampleName(String name){
		exampleName = name;
	}
	public boolean checkKeyName(String keyname){
		return feature.containsKey(keyname);
	}
	public String getKeyName(Feature value){
	    for(String key : feature.keySet()){
	        if(feature.get(key).equals(value)){
	            return key;
	        }
	    }
	    return null; // or prompt error message. 
	}
	
	public DefaultListModel<String> getNameSet(){
		return this.nameSet;
	}
	public HashMap<String,Feature> getAllFeatures(){
		return feature;
	}
	public void setFeatures(HashMap<String, Feature> h) {
		feature=h;
	}
	public String getTrainingExampleName(){
		return exampleName;
	}
	public void setTrainingExampleName(String name){
		exampleName = name;
	}
	public String toString(){
		String tostring = exampleName + ": ";
		for(int i =0;i < nameSet.size(); i++){
			tostring += nameSet.get(i) + " = " + feature.get(nameSet.get(i)).toString()+ "," + "\n" ;
		}
		return tostring;
	}
}