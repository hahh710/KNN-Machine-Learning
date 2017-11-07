import java.util.HashMap;

public class Example {
	private String exampleName;
	private HashMap<String,Feature> map; 
	public Example(){
		exampleName = null;
	}
	
	public void createExample(String name){
		this.exampleName = name;
		map = new HashMap<String,Feature>();
	}
	public void addFeature(String keyname,Feature value){
		map.put(keyname, value);
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
}