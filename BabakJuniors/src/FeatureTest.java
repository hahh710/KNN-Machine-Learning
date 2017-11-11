import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FeatureTest {
	Feature feature;
	Feature featureF;
	Feature featureC;
	float featureFloat;

	@Before
	public void setUp() throws Exception {
	    featureFloat = 2;
		feature = new Feature("test");
		featureF = new Feature(featureFloat);
		featureC = new Feature(2,2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFeature() {
		assertNotNull("Feature class is not null", feature);

	}

	@Test
	public void testgetStringValue() {
		assertEquals("Features name should be test", "test", feature.getStringValue());
		
	}

	@Test
	public void testgetNumValue() {
		assertEquals("The number value is 5", featureFloat , feature.getNumValue());

	}
	
	@Test
	public void testsetNumValue() {
		featureF.setNumValue(featureFloat);
		assertEquals("tests new value is 12", featureFloat, featureF.setNumValue(featureFloat));
	}
	
	
	
	

}