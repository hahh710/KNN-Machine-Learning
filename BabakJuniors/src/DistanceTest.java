import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DistanceTest {
	private Map<String,ArrayList<Float>> distances;
	private Map<String,ArrayList<Float>> normDist;
	private Map<TrainingExample, Integer> lookUpTable;
	private TestingExample testEx;
	@Before
	public void setUp() throws Exception {
		Example exMan = new Example();
		TestingExample testEx = new TestingExample("testEx", exMan);
		Distance testDist = new Distance(testEx);
		TrainingExample t1 = new TrainingExample ("t1", exMan);
		TrainingExample t2 = new TrainingExample ("t2", exMan);
		TrainingExample t3 = new TrainingExample ("t3", exMan);
		//add testing example to example
		exMan.addTrainingExample(testEx);
		
		//add training examples to example
		exMan.addTrainingExample(t1);
		exMan.addTrainingExample(t2);
		exMan.addTrainingExample(t3);

		//Add features to testing example
		testEx.addFloatFeature(fName, value, currentFeature)
		//add features to training example1
		
		//add features to training example2
		
		//add features to training example3
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	@Test
	public void testfindDistance() {
		
	}
	@Test
	public void normalizeDistance() {
		
	}
	@Test
	public void populateDistanceMap() {
		boolean pass=true;
		HashMap<String, ArrayList<Float>> testMap=new HashMap<String, ArrayList<Float>>();
		
		
	}
	@Test
	public void updateDistances() {
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
}
