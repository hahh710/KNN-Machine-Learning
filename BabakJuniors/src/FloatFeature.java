import java.util.ArrayList;
public class FloatFeature extends Feature {
	private CompositeFeature parent;
	private float value;

	public FloatFeature(String s, float value) {
		super(s);
		this.setValue(value);
		parent = null;
	}

	public Float getDistance(Feature f, String metric) {
		if (f instanceof FloatFeature) {
			if (metric.equals("absoluteDistance")) {
				return absoluteDistance(f);
			} else if (metric.equals("SquareDistance")) {
				return squareDistance(f);
			}
		}
		return null;
	}

	public Float absoluteDistance(Feature f) {
		if (f instanceof FloatFeature)
			return subValue(f);
		return null;
	}

	public Float squareDistance(Feature f) {
		return Math.abs((float) (Math.pow(value, 2) - Math.pow(((FloatFeature) f).getValue(), 2)));

	}
	public Float subValue(Feature f) {
		return this.value - ((FloatFeature) f).getValue();

	}

	public void setValue(float value) {
		this.value = value;
	}

	public Float getValue() {
		return value;
	}
	public ArrayList<Feature> getFeatureValue(ArrayList<Feature> features){
		features.add(this);
		return features;
	}

	/**
	 * (expected-actual)/expected * 100
	 * 
	 * @param f
	 */
	public Float calculateError(Feature f) {
		if (f instanceof FloatFeature)
			return (value - ((FloatFeature) f).getValue()) / value;
		// throw exception
		return null;
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
		int count =0;
		FloatFeature ff= this;
		Float predicted = (float)0;
		for(TrainingExample n:nn) {
			if(n.getFeature(ff.getStringID("",ff.getParent())) instanceof FloatFeature) {
				predicted+=((FloatFeature)(n.getFeature(ff.getStringID("", ff.getParent())))).getValue();
				count++;
			}
		}
		predicted=predicted/count;
		return (new FloatFeature(getFName(), predicted));
	}
	@Override
	public String toString() {
		String str = getFName()+": "+value;
		return str;
	}

}
