
/**
 *SqrFt
 *
 *@Authors: Babak Juniors 
 *@Purpose: An attribute of a house which takes in an integer and using that it gets a normalized value which is under a certain limit
 *
 *@field variables
 *	squareFeet: An integer value of squarefeet
 *	
 *@methods
 *	main:
 *	getNrmalizedValue: returns a float value which is under 0-1 depending on the squareFeet of an house.
 *
 */
public class SqrFt {
	// instance variables - replace the example below with your own
	private int squareFeet;
	/**
	 * Constructor for objects of class SquareFeet
	 */
	public SqrFt(int squareFeet)
	{
		// initialise instance variables
		this.squareFeet=squareFeet;
	}

	public int getSqrFt(){
		return squareFeet;
	}

	public float getNormalizedValue () {
		float value = this.squareFeet;

		return (float) (value / (10000));

		//if(this.squareFeet>2000 || this.squareFeet==2000){
		//value = (float) 2.0;
		//}else if(this.squareFeet>1000 || this.squareFeet<2000){
		//value = (float) 1.5;
		//}else{
		//value = (float) 1.0;
		//}
		//return value;

	}


}
