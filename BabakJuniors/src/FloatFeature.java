
public class FloatFeature extends Feature {

	private float value;

	public FloatFeature(String s, float value) {
		super(s);
		this.setValue(value);
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

	public float getValue() {
		return value;
	}

	/**
	 * (expected-actual)/expected * 100
	 * 
	 * @param f
	 */
	public float calculateError(Feature f) {
		if (f instanceof FloatFeature)
			return (value - ((FloatFeature) f).getValue()) / value;
		// throw exception
		return (float) 1.1;
	}

}
