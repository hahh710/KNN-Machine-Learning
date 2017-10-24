import java.util.ArrayList;
import java.util.List;

/**
 * House
 * ___
 * @author Babak Juniors
 *
 *
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
		houseAttributes.add(c);
		houseAttributes.add(a);
		houseAttributes.add(s);
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
	}
	public List<Object> getHouse(){
		return houseAttributes; 
	}
}
