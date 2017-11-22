
public class ComplexFeature extends Feature {
	private float nonImag;
	private float imag;
	public ComplexFeature(String s,float nonImag,float imag) {
		super(s);
		this.setNonImag(nonImag);
		this.setImag(imag);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float getDistance(Feature f, String metric) {
		// TODO Auto-generated method stub
		//this is a feature and f is a feature, compare this and f.... distance = this -f 
		return 0;
	}

	public float getNonImag() {
		return nonImag;
	}

	public void setNonImag(float nonImag) {
		this.nonImag = nonImag;
	}

	public float getImag() {
		return imag;
	}

	public void setImag(float imag) {
		this.imag = imag;
	}

}
