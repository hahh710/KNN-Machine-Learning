public class Feature {
	private String fname;
	private String stringValue;
	private Float numValue;
	private Integer corX;
	private Integer corY;
	
	public Feature(String fname,String s){
		this.fname = fname;
		stringValue = s;
		numValue = null;
		corX = null;
		corY = null;
	}
	public Feature (String fname, Float num){
		this.fname = fname;
		stringValue=null;
		numValue=num;
		corX = null;
		corY = null;
	}
	public Feature (String fname,Integer corX,Integer corY){
		this.fname = fname;
		stringValue=null;
		numValue=null;
		this.corX = corX;
		this.corY = corY;
	}
	public String getStringValue() {
		return stringValue;
	}
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	
	public Float getNumValue() {
		return numValue;
	}
	public void setNumValue(Float numValue) {
		this.numValue = numValue;
	}
	
	public Integer getCorX() {
		return corX;
	}
	public void setCorX(Integer corX) {
		this.corX = corX;
	}
	
	public Integer getCorY() {
		return corY;
	}
	public void setCorY(Integer corY) {
		this.corY = corY;
	}
	public String getFeatureName(){
		return fname;
	}
	public String toString(){
		if(stringValue != null){
			return stringValue;
		}else if(numValue != null){
			return numValue.toString();
		}else{
			return "(" + corX.toString() + "," +corY.toString()+ ")";
		}
	}
	
}