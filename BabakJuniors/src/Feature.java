/**
@Instance Variables
 *-fName : String : it holds name of the type of the feature ex) colour, Age, size.
 *-stringValue : String : it holds String value of the Feature. 
 *-numValue : Float : it holds the float value of the number value
 *-corX : Interger : it holds the value of coordinate of X value
 *-corY : Interger : it holds the value of coordinate of Y value 
 *-
 *
 *@Method
 *+getDistance(Feature f); abstract methods for subclass to override
 *+getFName() : Integer :  it is getter for FeatureName;
 *+setFname(String fName) : setter for the Feature Name;
 *
**/
public abstract class Feature {
	private String fName;
	public Feature(String s){
		setFName(s);
	}

	public String getFName(){
		return fName;
	}
	public void setFName(String fName){
		this.fName = fName;
	}
	public abstract float getDistance(Feature f) ;
}
