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
*/
public class House {
	private List<Object> houseAttributes = new ArrayList<Object>();
	private int price ;
	
	public House(Coordinates c, Age a, SqrFt s, int p) {
		//index 0 of arraylist has coordinates
		//index 1, Age
		//index 2, sqrFt 
		//index 3, price
		houseAttributes.add(0,c);
		houseAttributes.add(1,a);
		houseAttributes.add(2,s);
		houseAttributes.add(3,p);
		price = p;
	}
	
	public House(Coordinates c, Age a, SqrFt s) {//constructor for new house aka unknown price
		houseAttributes.add(0,c);
		houseAttributes.add(1,a);
		houseAttributes.add(2,s);
		price=0;
	}
	
	public House() {
		price=0;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int p) {
		price=p;
		houseAttributes.set(3,p);
	}
	public List<Object> getHouse(){
		return houseAttributes; 
	}
}
