import java.util.ArrayList;
import java.util.HashMap;


public class TrainingExample {
	private String exampleName;
	private HashMap<String,Feature> map; 
	private ArrayList<String>nameSet;

	public TrainingExample(){
		exampleName = null;
	}
	
	public void createExample(String name){
		this.exampleName = name;
		map = new HashMap<String,Feature>();
		nameSet = new ArrayList<String>();
	}
	public void addFeature(String keyname,Feature value){
		if(!map.containsKey(keyname)) {
			map.put(keyname, value);
			nameSet.add(keyname);
		}else{
			System.out.println("There is same name of feature");// print this statement in 
		}
		
	}
	public Feature getFeature(String keyname){
		return map.get(keyname);
	}
	public void removeFeature(String keyname){
		map.remove(keyname);
	}
	public String getExampleName(){
		return exampleName;
	}
	public void editFeature(String keyname, Feature value){
		map.replace(keyname, value);
	}
	public void editExampleName(String name){
		exampleName = name;
	}
	public boolean checkKeyName(String keyname){
		return map.containsKey(keyname);
	}
	public String getKeyName(Feature value){
	    for(String key : map.keySet()){
	        if(map.get(key).equals(value)){
	            return key;
	        }
	    }
	    return null; // or prompt error message. 
	}
	//
	public ArrayList<String> getNameSet(){
		return this.nameSet;
	}
}