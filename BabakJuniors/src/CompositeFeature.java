import java.util.ArrayList;

public class CompositeFeature extends Feature {
	private CompositeFeature parent;
	private ArrayList<Feature> subFeatures;
	private ArrayList<String> subFeatureNames;

	public CompositeFeature(String s) {
		super(s);
		parent = null;
		subFeatures = new ArrayList<Feature>();
		subFeatureNames = new ArrayList<String>();
	}
	public CompositeFeature(CompositeFeature f) {
		super(f.getFName());
		subFeatures = new ArrayList<Feature>();
		subFeatureNames = new ArrayList<String>();
	}

	public CompositeFeature getParent() {
		return parent;
	}
	public void setParent(CompositeFeature parent) {
		this.parent = parent;
	}
	public void addFeature(Feature feature) {
		if(feature instanceof CompositeFeature) {
			((CompositeFeature) feature).setParent(this);
		}
		subFeatures.add(feature);
		subFeatureNames.add(feature.getFName());
	}

	public ArrayList<Feature> getSubFeatures() {
		return subFeatures;
	}

	public void setSubFeatures(ArrayList<Feature> subFeatures) {
		this.subFeatures = subFeatures;
	}

	public ArrayList<String> getSubFeatureNames() {
		return subFeatureNames;
	}

	public void setSubFeatureNames(ArrayList<String> subFeatureNames) {
		this.subFeatureNames = subFeatureNames;
	}

	public Feature getSubFeature(int i) {
		return subFeatures.get(i);
	}

	public String getSubFeatureName(int i) {
		return subFeatureNames.get(i);
	} 
	public int getSubFeatureSize() {
		return subFeatures.size();
	}

	public int getSubFeatureNameSize() {
		return subFeatureNames.size();
	}
	public boolean isThereComposite() {
		for(int i=0;i<subFeatures.size();i++) {
			if(subFeatures.get(i) instanceof CompositeFeature) {
				return true;
			}
		}
		return false;


	}

	public String getStringID(String path,CompositeFeature current) {
		CompositeFeature newCurrent = current;
		if(current.getFName().equals("head")) {
			path = "Head/"+ path ;  //t.getTrainingExampleName();
			return path;
		}else {
			path = current.getFName() +"/"+path;
			newCurrent = current.getParent();
			return getStringID(path,newCurrent);
		}
	}
	@Override
	public Float getDistance(Feature f, String metric) {
		if(f instanceof CompositeFeature){
			CompositeFeature compf=(CompositeFeature)f;
			if(metric.equals("euclidean"))
				return euclideanDistance(compf);
		}
		return null;
	}
	public Float euclideanDistance(CompositeFeature f){
		float value=0;
		ArrayList<Float> theseFloats = new ArrayList<Float>();
		ArrayList<Float> thoseFloats = new ArrayList<Float>();
		
		for(Feature subF: subFeatures){
			if (subF instanceof FloatFeature){
				theseFloats.add(((FloatFeature) subF).getValue());
			}	
		}
		for(Feature subF: f.getSubFeatures()){
			if (subF instanceof FloatFeature){
				thoseFloats.add(((FloatFeature) subF).getValue());
			}	
		}
		if(theseFloats.size()==thoseFloats.size()){
			for(int i=0;i<theseFloats.size();i++){
				value+=Math.pow(theseFloats.get(i),2) - Math.pow(thoseFloats.get(i), 2);
			}
			return (float) Math.pow(value, 0.5);
		}
		else 
			return null;
	}
	public ArrayList<Feature> getFeatureValue(ArrayList<Feature> features){
		features.add(this);
		for(int i =0;i<subFeatures.size();i++) {
			subFeatures.get(i).getFeatureValue(features);
		}
		features.add(this);
		return  features;
	}
	@Override
	public Float calculateError(Feature f) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	@Override
	public String toString(String toString) {
		toString = toString + "(";
		for(int i =0; i < subFeatures.size();i++) {
			subFeatures.get(i).toString(toString);
		}
		toString = toString + ")";
		return toString;
	}
	 */

	@Override
	public String toString() {
		String str;
		if(getFName().equals("head"))
			str="";
		else
			str = getFName()+": (";

		for(Feature f: getSubFeatures()) {
			str= str + f.toString()+", ";
		}
		if(getFName().equals("head"))
			return str;
		return str + ")";
	}
}


