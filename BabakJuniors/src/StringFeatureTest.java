import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringFeatureTest {
	private Example example;
	TestingExample testingExampleS = new TestingExample("New", example);
	TestingExample testingExampleN;
	TestingExample testingExampleC;
	

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	public void testStringFeatureTest() {
		
	}

	@Test
	public void testgetDistance() {
		Distance distance = testingExampleS.getDistances();
		assertEquals(distance,testingExampleS.getDistances());
	}
}

