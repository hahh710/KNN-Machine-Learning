import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FeatureTest {
	Feature featureS;
	Feature featureF;
	Feature featureC;
	float featureFloat;

	@Before
	public void setUp() throws Exception {
	    featureFloat = 2;
		//featureS = new Feature("test");
		//featureF = new Feature(featureFloat);
		//featureC = new Feature(2,2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFeature() {
		assertNotNull("Feature class is not null", featureS);
		assertNotNull("Feature class is not null", featureC);
		assertNotNull("Feature class is not null", featureF);

	}

	@Test
	public void testgetFName() {
		//assertEquals("Features name should be test", "test", featureS.getStringValue());
		
	}

	@Test
	public void testsetFName() {
		//assertEquals("The number value is 5", featureFloat , feature.getNumValue());

	}
	
	@Test
	public void testsetNumValue() {
		//featureF.setNumValue(featureFloat);
		//assertEquals("tests new value is 12", featureFloat, featureF.setNumValue(featureFloat));
	}
	
	
	
	

}