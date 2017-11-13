import java.util.HashMap;

import javax.swing.DefaultListModel;


public class TrainingExample {
	private String exampleName;
	private HashMap<String,Feature> feature; 
	private DefaultListModel<String>nameSet;
	private Example ex;
	public TrainingExample(Example exm){
		ex=exm;
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
		//when adding a feature of string value, then must 1. check if rank exists. if so append value to ranking list, 
		//if not create new list and add value to ranking list
		if(!feature.containsKey(keyname)) {
			nameSet.addElement(keyname);
			feature.put(keyname, value);
			if(value.getStringValue()!=null) {
				for(SubjectiveRanking sR: ex.getSubjectiveRankings()) {
					if(sR.getRankingListType().equalsIgnoreCase(keyname)) {
						sR.addToSubjectiveRanking(value.getStringValue());
					}
				}
				SubjectiveRanking sr = new SubjectiveRanking(keyname);
				ex.addSubjectiveRankings(sr);
				feature.put(keyname, value);
				sr.addToSubjectiveRanking(value.getStringValue());
			}
		}
		else{
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
			tostring += nameSet.get(i)+ " = " + feature.get(nameSet.get(i)).toString()+ "," + "\n" ;
		}
		return tostring;
	}
}