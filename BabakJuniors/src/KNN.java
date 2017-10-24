import java.util.ArrayList;
import java.util.List;

/**
*KNN
*
*@Authors: Babak Juniors 
*@Purpose: Determine the price of a house given its house attributes compared to similar houses
*
*@field variables
*	houses: A collection of houses with known attributes and price
*	nearestNeighbors: A collection of houses used to determine the price of a certain house
*	
*@methods
*	main:
*	findKNN:
*	findDistance:
*	findPrice:
*
*/
public class KNN {
	private List <House> houses;
	private List <House> nearestNeighbors;
	public KNN (){
		houses = new ArrayList<House>();
		nearestNeighbors = new ArrayList<House>();
	}
	/**
	*findKNN
	*@param 
	*-an integer k representing the number of neighbors looked at to determine price of new house
	*-an object of type House, called newHouse which will be compared against other houses
	*
	*1. Reset list of nearestNeighbors right before function call*smelly needs fixing
	*2. Iterate through the collection of houses and append the one with shortest distance to the new house
	*3.	Repeat the process on the same collection less the appended house
	*4. Repeat k times
	*		
	*/
	public void findKNN (int k, House newHouse, ArrayList<House> potentialNN){
		House nearestNeighbor = new House(); 
		if(k>0){ //if K>1 then must find nearestNeighbor and append to list of NN
			float distance = -1;
			float smallestDistance=-1;
			for(House h:potentialNN){
				distance=findDistance(h, newHouse);
				if (smallestDistance==-1){//first house in list will initially be NN
					smallestDistance= distance;
				}	
				if(smallestDistance > distance){//new smallest distance
					smallestDistance=distance;
					nearestNeighbor=h;
				}
			}
			nearestNeighbors.add(nearestNeighbor);//append NN			
			potentialNN.remove(nearestNeighbor);//remove the determined nearestNeighbor
			findKNN(k-1, newHouse, potentialNN);//Recursively call until k neighbors have been determined
		}
	//K nearest neighbors have been determined
	}
	/**
	*findPrice(List<House> NN)
	*@Parameters
	*-list of houses -> nearest neighbors determined by findKNN method
	*
	*@returns
	*-returns price of new house -> simply calculated by averaging nearest neighbors for the purposes of milestone 1
	*
	*/
	public float findPrice(){
		float sum=0;
		int count=0;
		for(House h:nearestNeighbors){
			sum+=h.getPrice();
			count++;
		}
		return sum/count;
	}
	/**
	*findDistance (House h1, House h2)
	*@param
	*	-two houses that are being compared
	*@return
	*	-return a float representing the distance between the two houses
	*	
	*Determine distance between two houses
	*	//index 0 of arraylist has coordinates
		//index 1, Age
		//index 2, sqrFt 
		//index 3, price
	*/
	public float findDistance(House h1, House h2){
		return findCoordinateDistance(House h1, House h2)+findAgeDistance(House h1, House h2)+findSqrFtDistance(House h1, House h2);
	}
	public float findCoordinateDistance(House h1, House h2) {
		return Math.sqrt(Math.pow(h1.getCorX()-h2.getCorX(), 2)+ Math.pow(h1.getCorY()-h2.getCorY(), 2));
	}
	public float findAgeDistance(House h1, House h2) {
		return h1.getAge()=h2.getAge();
	}
	public float findSqrFtDistance(House h1, House h2) {
		return h1.getSqrFt()-h2.getSqrFt();
	}
/**
 * 
 */
	public static void main(){
		
	}
}