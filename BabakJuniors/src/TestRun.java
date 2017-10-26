import java.util.ArrayList;

public class TestRun {
	/**
	 *TestRun
	 *
	 *@Authors: Arsalan Sadiq 
	 *@Purpose: A class which allows to run the test cases
	 *
	 *@field variables
	 *
	 *	
	 *@methods
	 *	main:
	 *	all the test cases are being run in
	 *
	 */
	public TestRun(){
		
	}
	/**
	 * printTestInfo will print the training examples for this test
	 * @param houses list of training examples to be used
	 * @param n the test number
	 */
	public static void printTestInfo(ArrayList<House> houses, int n) {
		int c=0;
		System.out.println("Test "+n);
		System.out.println("");
		System.out.println("");
		for(House h:houses) {
			System.out.println("Training example " + c+": Coordinate = ("+ h.getCorX()+","+h.getCorY()+"), Age = "+h.getAge()+", SqrFt = "
					+ ""+ h.getSqrFt()+", Price = "+ h.getPrice());
			c++;
		}	
	}
	/**
	 * runTest method will find the price of the new house given the k neighbors
	 * @param r the instance of the running KNN
	 * @param k the number of K neighbors
	 */
	public static void runTest(KNN r, int k) {
		//reset list of nearest neighbors
		r.resetNN();
		//find nearest neighbors
		r.findKNN(k, r.getNewHouse(), r.getHouses());
		//calculate price based off of nearest neighbors
		r.setNewHousePrice();
		System.out.println("The testing example is: K = "+ k+", Coordinate = ("+r.getNewHouse().getCorX()+","+r.getNewHouse().getCorY()+"), Age = "
		+r.getNewHouse().getAge()+", Sqrft = "+r.getNewHouse().getSqrFt());
		System.out.println("The price of the testing example is "+r.getNewHouse().getPrice());
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String [ ] args) {
		KNN running = new KNN();
		//populate the list of training examples
		running.addHouse(new Coordinates(12,25),new Age("New"),new SqrFt(1200), 500000);
		running.addHouse(new Coordinates(10,50), new Age("Old"),new SqrFt(1000), 300000);
		running.addHouse(new Coordinates(30,100), new Age("New"), new SqrFt(800),400000);
		running.setNewHouse(new Coordinates(15, 20),  new Age("New"),new SqrFt(1000));	
		//run test 1 using known houses and k=1
		printTestInfo(running.getHouses(), 1);
		runTest(running,1);

		//run test 2 using known houses and k=2

		printTestInfo(running.getHouses(), 2);
		runTest(running, 2);
		
		//run test 3 using known houses and k=3
		printTestInfo(running.getHouses() ,3);
		runTest(running,3);
	
	}
}
