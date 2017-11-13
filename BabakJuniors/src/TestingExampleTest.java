
import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestingExampleTest {
	TestingExample testingExampleS;
	TestingExample testingExampleN;
	TestingExample testingExampleC;
	Example example;

	@Before
	public void setUp() throws Exception {
		example = new Example();
		testingExampleS = new TestingExample( example);
		testingExampleN = new TestingExample( example);
		testingExampleC = new TestingExample( example);
	}

	@After
	public void tearDown() throws Exception {
	}

	public void testTestingExampleTest() {
		assertNotNull("Testing Example is not null", testingExampleS);
		assertNotNull("Testing Example is not null", testingExampleN);
		assertNotNull("Testing Example is not null", testingExampleC);
	}

	@Test
	public void testgetDistance() {
		assertNotNull("Distances should not null",testingExampleS.getDistances());
		assertNotNull("Distances should not null",testingExampleN.getDistances());
		assertNotNull("Distances should not null",testingExampleC.getDistances());
	}

	@Test
	public void testPredictFeature() {

	}
}
