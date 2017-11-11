import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FeatureTest {
	Rank rank;
	Feature feature;
	Feature featureF;
	Feature featureC;
	

	@Before
	public void setUp() throws Exception {
		float featureFloat = 2;
		feature = new Feature("test");
		featureF = new Feature(featureFloat);
		featureC = new Feature(2,2);
		

		rank = new Rank("Name", feature);
		
		//rank = new Rank(test);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRank() {
		assertNotNull("Feature class is not null", feature);

	}

	@Test
	public void testgetStringValue() {
		assertEquals("Features name should be test", "test", feature.getStringValue());
		
	}

	
	

}