import java.util.ArrayList;

public class StringFeature extends Feature{
	private CompositeFeature parent;
	private String fValue;
	public StringFeature(String s, String fValue) {
		super(s);
		setfValue(fValue);
		parent = null;
	}
	public String getFValue(){
		return fValue;
	}
	public void setfValue(String value){
		fValue=value;
	}
	
	@Override
	public Float getDistance(Feature f, String metric) {
		float distance;
		if(metric.equals("commonletter")){
			distance = commonLetter(f); 
		}else if(metric.equals("sizeofstring")){
			distance= lengthOfString(f);
		}else{
			distance = lexGraphic(f);
		}
		return distance;
	}

	public float commonLetter(Feature f){
		float distance=fValue.length();
		float count =0;
		if(f instanceof StringFeature){
			StringFeature feature = (StringFeature)f;
			//if(feature.getFValue().length() >= fValue.length()){
			//	distance = feature.getFValue().length(); 
			//}else distance = fValue.length();
			
			for(int i=0;i < fValue.length();i++){
				for(int j=0;j< feature.getFValue().length();j++)
					if(fValue.charAt(i) == feature.getFValue().charAt(j)){
						count++;
						i++;
				}
			}
			
		}
		return distance / count * 100;
	}
	
	public float lengthOfString(Feature f){
		float distance=0;
		StringFeature feature = (StringFeature)f;
		distance = Math.abs(fValue.length() - feature.getFValue().length());
		return distance;
	}
	
	public float lexGraphic(Feature f){
		StringFeature feature = (StringFeature)f;
		return fValue.compareToIgnoreCase(feature.getFValue());
		
	}
	
	public Float calculateError(Feature f) {
		if (f instanceof FloatFeature){
			if(!fValue.equals(f.getFName())){
				return (float) 100;
			}else{
				return (float) 0;
			}
		}
			
		// throw exception
		return (float) 1.1;
	}
	@Override
	public ArrayList<Feature> getFeatureValue(ArrayList<Feature> features){
		features.add(this);
		return features;
	}
	public CompositeFeature getParent() {
		return parent;
	}
	public void setParent(CompositeFeature parent) {
		this.parent = parent;
	}
	public String getStringID(String path,CompositeFeature current) {
		CompositeFeature newCurrent = current;
		if(current.getFName().equals("head")) {
			path = "Head->"+ path ;  //t.getTrainingExampleName();
			return path;
		}else {
			path = current.getFName() +"->"+path;
			newCurrent = current.getParent();
			return getStringID(path,newCurrent);
		}
	}
	public Feature predictFeature(ArrayList<TrainingExample> nn) {
		return new StringFeature(getFName(),((StringFeature) (nn.get(0).getFeature(getStringID("",getParent())))).getFValue() );
	}
	@Override
	public String toString() {
		String str = getFName() + ": "+ fValue;
		return str;
	}
}
