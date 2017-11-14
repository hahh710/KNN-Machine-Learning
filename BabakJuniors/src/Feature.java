/**
@Instance Variables
 *-fName : String : it holds name of the type of the feature ex) colour, Age, size.
 *-stringValue : String : it holds String value of the Feature. 
 *-numValue : Float : it holds the float value of the number value
 *-corX : Interger : it holds the value of coordinate of X value
 *-corY : Interger : it holds the value of coordinate of Y value 
 *-
 *
 *@Methods
 *+ getStringValue() : String : It returns String value of the Feature; 
 *+getNumValue() : Integer : It returns Integer value of number value of the Feature;
 *+setNumValue(Float numValue) : It is setter for the number value of the feature; 
 *+getCorX() : Integer  : getter for coordinate X value;
 *+setCorX(Integer corX) : it is setter for the coordinate X value;
 *+getCorY() : Integer : getter for coordinate Y value;
 *+setCorY(Integer corY) : setter for coordinate Y value ;
 *+getFName() : Integer :  it is getter for FeatureName;
 *+getRank(Example example) : Integer : It checks the every index of the rank and return the index of the feature contained.
 *+setFname(String fName) : setter for the Feature Name;
 *+toString() : String  : it return the String of the Feature value; 
 *
**/
public class Feature {
	private String stringValue;
	private Float numValue;
	private Integer corX;
	private Integer corY;
	private Rank rankList;
	private String fName;
	public Feature(String s){
		stringValue = s;
		numValue = null;
		corX = null;
		corY = null;
	}
	public Feature (Float num){
		stringValue=null;
		numValue=num;
		corX = null;
		corY = null;
	}
	public Feature (Integer corX,Integer corY){
		stringValue=null;
		numValue=null;
		this.corX = corX;
		this.corY = corY;
	}
	public String getStringValue() {
		return stringValue;
	}
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	
	public Float getNumValue() {
		return numValue;
	}
	public void setNumValue(Float numValue) {
		this.numValue = numValue;
	}
	
	public Integer getCorX() {
		return corX;
	}
	public void setCorX(Integer corX) {
		this.corX = corX;
	}
	
	public Integer getCorY() {
		return corY;
	}
	public void setCorY(Integer corY) {
		this.corY = corY;
	}
	public String getFName(){
		return fName;
	}
	public int getRank(Example example) {
		Integer index = null;
		for(int i =0;i<example.getRankInformation().size();i++){
			if(example.getRankInformation().get(i).getName().contains(fName)){
				index = example.getRankInformation().get(i).getlist().indexOf(this);
			}
		}
		return index;
	}
	public void setFname(String fName){
		this.fName = fName;
	}
	public String toString(){
		if(stringValue != null){
			return stringValue;
		}else if(numValue != null){
			return numValue.toString();
		}else{
			return "(" + corX.toString() + "," +corY.toString()+ ")";
		}
	}
}
