import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

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
	private ArrayList<Feature> subFeatures;
	public Feature(String s){
		setFName(s);
		subFeatures = new ArrayList<Feature>();
	}

	public String getFName(){
		return fName;
	}
	public void setFName(String fName){
		this.fName = fName;
	}
	public void addSubFeature(Feature f) {
	subFeatures.add(f);
	}
	public abstract float getDistance(Feature f, String metric) ;
}
