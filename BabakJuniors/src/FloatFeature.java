
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
		if(metric.equals("absoluteDistance")){
			return absoluteDistance(f);
		}else if(metric.equals("SquareDistance")){
			return squareDistance(f);
		}
			
		return 0;
	}
	public float absoluteDistance(Feature f){
		if(f instanceof FloatFeature)
			return subValue(f);
		return 0;
	}
	public float squareDistance(Feature f){
		if(f instanceof FloatFeature)
			return (float) (Math.pow(value, 2) - Math.pow(((FloatFeature) f).getValue(), 2));
		return 0;
		
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


