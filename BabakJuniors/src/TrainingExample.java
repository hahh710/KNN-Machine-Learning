import java.util.HashMap;
import java.util.ArrayList;
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
	private String name;
	private Example manager;
	private ArrayList<Feature> features; 

	public TrainingExample(String name, Example manager){
		this.manager=manager;
		features = new ArrayList<Feature>();
		this.name = name;
	}
	//public createFeatureType{
	//create feature type
	public void addFeature(Feature f){
		//if this keyname exists then
		if(!features.contains(f)) {
			features.add( f);
		}else{
			System.out.println("There is same name of feature");// print this statement in 
		}

	}
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
	public void setFeatures(ArrayList<Feature> list) {
		features=list;
	}
	public String toString(){
		String tostring = exampleName + ": ";
		for(int i =0;i < nameSet.size(); i++){
			tostring += nameSet.get(i) + " = " + feature.get(nameSet.get(i)).toString()+ "," + "\n" ;
		}
		return tostring;
	}
}