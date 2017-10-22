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
	private int price;
	private List<HouseAttribute> houseAttributes;
	public House(Coordinates c, Age a, SqrFt s, int p) {
		price =p;
	}
	public House(Coordinates c, Age a, SqrFt s) {//constructor for new house aka unknown price
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
	public 
}
