import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringFeatureTest {
	TestingExample testingExampleS;
	TestingExample testingExampleN;
	TestingExample testingExampleC;
	Example example;

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
		assertNotNull("Distances should not null",testingExampleS.getDistances());
	}
}
