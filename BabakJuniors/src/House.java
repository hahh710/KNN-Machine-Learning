/**
*House
*
*@Authors: Hunho Ha, Ahmed Khattab, Arsalan Sadiq, Jeff Tudor
*@Purpose: collecting all the Attributes(Coordinates, Age, SqrFt, and price) into arraylist and returning as House class.
*
*@field variables
*	houseAttributes : ArrayList contains Coordinates, Age, SqrFt, and Price.
*	Price: The price of the 
*	
*@methods
*	getPrice
*	setPrice
*	getHouse
*	getCorx
*	getCorY
*	getAge
*	getSqrFt
*/
public class House {
	private float price ;
	private String age;
	private int corX;
	private int corY;
	private int sqrFt;
	
	public House(int x, int y,  String a, int s, float p) {
		/*
		 * Constructor with price.
		 * index 0 of Arraylist has coordinates
		 * index 1, Age
		 * index 2, sqrFt 
		 * index 3, price
		 */
		age=a;
		corX=x;
		corY=y;
		sqrFt=s;
		price = p;
	}
	
	public House(int x, int y, String a, int s) {//constructor for new house aka unknown price
		/*
		 * Constructor without price
		 * and price will be 0
		 */
		age=a;
		corX=x;
		corY=y;
		sqrFt=s;
		price=0;
	}
	
	public House() {
		/*
		 * Construct without any information.
		 * Just making a price 0 and empty arraylist of house.
		 */
		price=0;
	}
	
	/**
	 * Getter for price.
	 * @return a float of the price
	 */
	public float getPrice() {
		return price;
	}
	
	/**
	 * Setter for price
	 */
	public void setPrice(float f) {
		price=f;
	}

	/**
	 * getter for Attributes(Coordinates, Age, SqrFt) 
	 * @return the cordinates of X
	 */
	public int getCorX(){
		return corX;
	}
	
	/**
	 * 
	 * Getter for cordinates for Y
	 * @return int cordinates of y
	 */
	public int getCorY(){
		return corY;
	}
	
	/**
	 * Getter for Age
	 * @returns either a 1 or 0 depending on whether the entered age is old or new.
	 */
	public int getAge(){
		if(age=="New")
			return 1;
		if(age=="Old")
			return 0;
		return 0;
	}
	
	/**
	 * Getter for Square feet of house
	 * @returns an int of the square feet
	 */
	public int getSqrFt(){
		return sqrFt;
	}
	
	/**
	 * Gets the String AGE
	 * @return a string of age (new or old)
	 */
	public String getAgeString(){
		return age;
	}
}
