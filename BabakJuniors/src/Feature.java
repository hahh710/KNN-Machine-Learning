import java.util.ArrayList;


/**
@Instance Variables
 *-fName : String : it holds name of the type of the feature ex) colour, Age, size.
 *-stringValue : String : it holds String value of the Feature. 
 *-numValue : Float : it holds the float value of the number value
 *-corX : Integer : it holds the value of coordinate of X value
 *-corY : Integer : it holds the value of coordinate of Y value 
 *-
 *
 *@Method
 *+getDistance(Feature f); abstract methods for subclass to override
 *+getFName() : Integer :  it is getter for FeatureName;
 *+setFname(String fName) : setter for the Feature Name;
 *
 *add feature
 *ask name
 *ask string, number
 *new StrngFeature()
 *or
 *new FloatFeature
 *
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
	public abstract CompositeFeature getParent();
	public void setFName(String fName){
		this.fName = fName;
	}
	public abstract String getStringID(String s, CompositeFeature c);
	public abstract Float getDistance(Feature f, String metric) ;
	public abstract Float calculateError(Feature f);
	public abstract ArrayList<Feature> getFeatureValue(ArrayList<Feature> features);
	public abstract String toString();

}
