import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompositeFeatureTest {

	private CompositeFeature cfHead,cF2,cF3,cF4;

	@Before
	public void setUp() throws Exception {
		cfHead = new CompositeFeature("Head");
		cF2 = new CompositeFeature("CompositeFeature2");
		cF3 = new CompositeFeature("CompositeFeature3");
		cF4 = new CompositeFeature("CompositeFeature4");

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDistance() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculateError() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompositeFeature() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddFeature() {
		cfHead.addFeature(cF2);
		assertEquals(1,cfHead.getSubFeatureSize());
	}

	@Test
	public void testGetSubFeatures() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSubFeatures() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSubFeatureNames() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSubFeatureNames() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSubFeature() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSubFeatureName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSubFeatureSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSubFeatureNameSize() {
		fail("Not yet implemented");
	}

}
