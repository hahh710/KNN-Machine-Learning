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
	
	public static void main(String [ ] args) {
		KNN running = new KNN();
		running.addHouse(new Coordinates(12,25),new Age("New"),new SqrFt(1200), 500000);
		running.addHouse(new Coordinates(10,50), new Age("Old"),new SqrFt(1000), 300000);
		running.addHouse(new Coordinates(30,100), new Age("New"), new SqrFt(800),400000);
		running.setNewHouse(new Coordinates(15, 20),  new Age("New"),new SqrFt(1000));		
		running.resetNN();
		running.findKNN(1, running.getNewHouse(), running.getHouses());
		running.setNewHousePrice();
		System.out.println("Test 1");
		System.out.println("");
		System.out.println("");

		System.out.println("Training example 2: Coordinates (10, 50) Age (Old) SqrFt(1000) Price (300000)");
		System.out.println("Training example 3: Coordinates (30, 100) Age (New) SqrFt(800) Price (400000)");
		System.out.println("Training example 1: Coordinates (12, 25) Age (New) SqrFt(1200) Price (500000)");
		System.out.println("The testing example is: K = 1 Coordinates (12, 25) Age (New) SqrFt(1200)");
		System.out.println("The price of the testing example is "+running.getNewHouse().getPrice());
		System.out.println("");
		System.out.println("");
		running.resetNN();
		running.findKNN(2, running.getNewHouse(), running.getHouses());
		running.setNewHousePrice();
		System.out.println("Test 2");
		System.out.println("");
		System.out.println("");
		System.out.println("Training example 1: Coordinates (12, 25) Age (New) SqrFt(1200) Price (500000)");
		System.out.println("Training example 2: Coordinates (10, 50) Age (Old) SqrFt(1000) Price (300000)");
		System.out.println("Training example 3: Coordinates (30, 100) Age (New) SqrFt(800) Price (400000)");
		System.out.println("The testing example is: K = 2 Coordinates (12, 25) Age (New) SqrFt(1200)");
		System.out.println("The price of the testing example is "+running.getNewHouse().getPrice());
		System.out.println("Number of NN = " + running.getNearestNeighbors().size());
		System.out.println("");
		running.resetNN();
		running.findKNN(3, running.getNewHouse(), running.getHouses());
		running.setNewHousePrice();
		System.out.println("Test 3");
		System.out.println("");
		System.out.println("");
		System.out.println("Training example 1: Coordinates (12, 25) Age (New) SqrFt(1200) Price (500000)");
		System.out.println("Training example 2: Coordinates (10, 50) Age (Old) SqrFt(1000) Price (300000)");
		System.out.println("Training example 3: Coordinates (30, 100) Age (New) SqrFt(800) Price (400000)");
		System.out.println("The testing example is: K = 3 Coordinates (12, 25) Age (New) SqrFt(1200)");
		System.out.println("The price of the testing example is "+running.getNewHouse().getPrice());
		System.out.println("Number of NN = " + running.getNearestNeighbors().size());
		System.out.println("");
	}
}
