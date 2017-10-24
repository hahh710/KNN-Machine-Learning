/**
 * Write a description of class 	Age here.
 *
 */
public class Age implements HouseAttributes{
	

/*
public enum age{
	Old,New;		
}
*/
	
private String ageValue;
private String Old = "Old";
private String New = "New";

	public Age(String ageValue) {
		this.ageValue=ageValue;
	}
	
	public float getNormalizedValue() {
		
		if(Old == ageValue) {
			return (float) 0.5;
		}
		else if(New == ageValue) {
			return (float) 1.5;
		}
		else {
			return 0;	
		}
	}
	
	

}
