import java.util.ArrayList;
public class CompositeFeature extends Feature {
	private ArrayList<Feature> subFeatures;
	private ArrayList<String> subFeatureNames;
	public CompositeFeature(String s) {
		super(s);
		subFeatures = new ArrayList<Feature>();
		subFeatureNames = new ArrayList<String>();
	}
	public void addFeature(Feature feature) {
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
	
	public int getSubFeatureSize(){
		return subFeatures.size();
	}
	
	public int getSubFeatureNameSize(){
		return subFeatureNames.size();
	}
	
	@Override
	public Float getDistance(Feature f, String metric) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Float calculateError(Feature f) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
