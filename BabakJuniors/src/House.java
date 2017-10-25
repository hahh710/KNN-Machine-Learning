import java.util.ArrayList;
import java.util.List;
/**
*House
*
*@Authors: Hunho Ha
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
	private List<Object> houseAttributes = new ArrayList<Object>();
	private float price ;
	
	public House(Coordinates c, Age a, SqrFt s, int p) {
		/*
		 * Constructor with price.
		 * index 0 of Arraylist has coordinates
		 * index 1, Age
		 * index 2, sqrFt 
		 * index 3, price
		 */
		houseAttributes.add(0,c);
		houseAttributes.add(1,a);
		houseAttributes.add(2,s);
		price = p;
	}
	
	public House(Coordinates c, Age a, SqrFt s) {//constructor for new house aka unknown price
		/*
		 * Constructor without price
		 * and price will be 0
		 */
		houseAttributes.add(0,c);
		houseAttributes.add(1,a);
		houseAttributes.add(2,s);
		price=0;
	}
	
	public House() {
		/*
		 * Construct without any information.
		 * Just making a price 0 and empty arraylist of house.
		 */
		price=0;
	}
	
	/*
	 * Getter and setter for price.
	 */
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float f) {
		price=f;
	}
	/*
	 * getter for House. 
	 */
	public List<Object> getHouse(){
		return houseAttributes; 
	}
	/*
	 * getter for Attributes(Coordinates, Age, SqrFt) 
	 */
	public int getCorX(){
		return ((Coordinates) houseAttributes.get(0)).getX();
	}
	
	public int getCorY(){
		return ((Coordinates) houseAttributes.get(0)).getY();
	}
	public float getAge(){
		return (((Age) houseAttributes.get(1)).getNormalizedValue());
	}
	public float getSqrFt(){
		return (((SqrFt) houseAttributes.get(2)).getNormalizedValue());
	}
}
