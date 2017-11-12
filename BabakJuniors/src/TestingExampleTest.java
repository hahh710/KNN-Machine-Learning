
import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestingExampleTest {
	TestingExample testingExampleS;
	TestingExample testingExampleN;
	TestingExample testingExampleC;
	Feature featureS;
	Feature featureN;
	Feature featureC;
	Example example;

	@Before
	public void setUp() throws Exception {
		example = new Example();
		testingExampleS = new TestingExample(featureS, 20, example);
		testingExampleN = new TestingExample(featureN, 20, example);
		testingExampleC = new TestingExample(featureC, 20, example);
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
		assertEquals("Features name should be test", "test", featureS.getStringValue());
	}

	@Test
	public void testPredictFeature() {

	}
}
