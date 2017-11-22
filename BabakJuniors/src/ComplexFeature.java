
public class ComplexFeature extends Feature {
	private float nonImag;
	private float imag;
	float imagDiff,nonImagDiff;
	public ComplexFeature(String s,float nonImag,float imag) {
		super(s);
		this.setNonImag(nonImag);
		this.setImag(imag);
		imagDiff=0;
		nonImagDiff=0;
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float getDistance(Feature f, String metric) {
		// TODO Auto-generated method stub
		//this is a feature and f is a feature, compare this and f.... distance = this -f type name = new type();
		if(metric.equals("complexDistance"))
			 complexDistance(f);
		return 0;
	}
	public void complexDistance(Feature f){
		if(f instanceof ComplexFeature)
			this.imagDiff = subImag(f);
			this.nonImagDiff = subNonImag(f);
			
	}
	public float subImag(Feature f){
		return this.imag - ((ComplexFeature) f).getImag() ;
		
	}
	
	public float subNonImag(Feature f){
		return this.nonImag - ((ComplexFeature) f).getNonImag() ;
		
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
