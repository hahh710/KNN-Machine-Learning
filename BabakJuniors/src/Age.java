/**
*Age
*
*@Authors: Ahmed Khattab
*@Purpose: Determine the age of a house given whether its old or new
*
*@field variables
*	ageValue: A String to hold the Age entered
*	Old: A String which holds the Age Old
*	New: A String which holds the Age New
*	
*@methods
*	getNormalizedValue
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
		
		if(Old.equals(ageValue)) {
			return (float) 0.5;
		}
		else if(New.equals(ageValue)) {
			return (float) 0.8;
		}
		else {
			return 0;	
		}
	}
	
	

}
