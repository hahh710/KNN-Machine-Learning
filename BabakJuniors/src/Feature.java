
public class Feature {
	private String stringValue;
	private Float numValue;
	private Integer corX;
	private Integer corY;
	private Rank rankList;
	private String fName;
	public Feature(String s){
		stringValue = s;
		numValue = null;
		corX = null;
		corY = null;
	}
	public Feature (Float num){
		stringValue=null;
		numValue=num;
		corX = null;
		corY = null;
	}
	public Feature (Integer corX,Integer corY){
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
	public String getFName(){
		return fName;
	}
	public void setRankList(Rank r) {
		rankList=r;
	}
	public int getRank() {
		return rankList.getPosition(stringValue);
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
