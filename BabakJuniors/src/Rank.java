import java.util.ArrayList;

//This Rank class is for subjective Rank system.
public class Rank {
	private String name;
	private ArrayList<Feature>list;
	public Rank(String name,Feature feature){
		this.name = name;
		list = new ArrayList<Feature>();
		list.add(feature);
	}
	public void createRank){
		
	}
	public void addInRank(Feature feature){
		if(!list.contains(feature)){
			list.add(feature);
		}
	}
	public String getName(){
		return name;
	}
	public boolean checkName(String name){
		if(this.name == name) return true;
		else return false;
	}
	public ArrayList<Feature> getlist(){
		return list;
	}
}
