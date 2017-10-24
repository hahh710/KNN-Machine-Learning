
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

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getSqrFt(){
    		return squareFeet;
    }
    
    public float getNormalizedValue () {
    	float value=(float) 0;
    	if(this.squareFeet>2000 && this.squareFeet==2000){
    		value = (float) 2.0;
    	}else if(this.squareFeet>1000 && this.squareFeet<2000){
    		value = (float) 1.5;
    	}else{
    		value = (float) 1.0;
    	}
    	return value;
    }
}
