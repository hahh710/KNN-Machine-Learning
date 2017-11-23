
public class FloatFeature extends Feature{


	private float value;
	float valueDiff;
	public FloatFeature(String s,float value) {
		super(s);
		this.setValue(value);
		valueDiff=0;
	}
	
	@Override
	public float getDistance(Feature f, String metric) {
		if(metric.equals("floatFeature"))
			 complexDistance(f);
		return 0;
	}
	public void complexDistance(Feature f){
		if(f instanceof ComplexFeature)
			this.valueDiff = subValue(f);
			
			
	}

	
	public float subValue(Feature f){
		return this.value - ((FloatFeature) f).getValue() ;
		
	}
	
	public void setValue(float value) {
		this.value = value;
	}

	public float getValue() {
		return value;
	}

	
}


