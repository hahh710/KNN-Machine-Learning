/**
 * 
 * Float Feature
 * 
 * 
 */
import java.util.ArrayList;
public class FloatFeature extends Feature {
	private CompositeFeature parent;
	private Float value;

	public FloatFeature(String s) {
		super(s);
		value=null;
		parent = null;
	}

	public FloatFeature(String s, float value) {
		super(s);
		this.setValue(value);
		parent = null;
	}

	public Float getDistance(Feature f, String metric) {
		if (f instanceof FloatFeature) {
			if(((FloatFeature) f).getValue()!=null && value!=null) {
				if (metric.equals("absoluteDistance")) {
					return Math.abs(absoluteDistance(f));
				} else if (metric.equals("SquareDistance")) {
					return Math.abs(squareDistance(f));
				}
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
	public String getStringID(String path,Feature current) {
		CompositeFeature newCurrent = null;
		if(current instanceof CompositeFeature) {
			newCurrent = (CompositeFeature)current;
		}
		else{
			path = current.getFName();
			newCurrent = current.getParent();
			//return getStringID(path,newCurrent);
		}
		if(newCurrent.getFName().equals("head")) {
			path = "Head->"+ path ;  //t.getTrainingExampleName();
			return path;
		}else //if(current instanceof StringFeature ||current instanceof FloatFeature) {
			path = newCurrent.getFName() +"->"+path;
		newCurrent = newCurrent.getParent();
		return getStringID(path,newCurrent);

	}



	public Feature predictFeature(ArrayList<TrainingExample> nn) {

		int count =0;
		FloatFeature ff= this;
		Float predicted = (float)0;
		for(TrainingExample n:nn) {
			if(n.getFeature(ff.getStringID("",ff)) instanceof FloatFeature) {
				predicted+=((FloatFeature)(n.getFeature(ff.getStringID("", ff)))).getValue();
				count++;
			}
		}
		predicted=predicted/count;
		value=predicted;
		return (new FloatFeature(getFName(), predicted));
	}
	@Override
	public String toString() {
		String str = getFName()+": "+value;
		return str;
	}

}
