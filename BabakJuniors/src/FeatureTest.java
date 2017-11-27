import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FeatureTest {
	private CompositeFeature cfHead, cF2;
	//private String ID;

	@Before
	public void setUp() throws Exception {
		cfHead = new CompositeFeature("Head");
		cF2 = new CompositeFeature("CompositeFeature2");
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testGetFName() {
		assertEquals("Head",cfHead.getFName());
	}

	@Test
	public void testSetFName() {
		String s = "New Head";
		cfHead.setFName("New Head");
		assertEquals(s,cfHead.getFName());
	}

	@Test
	public void testGetDistance() {
		assertTrue(true);
	}

	@Test
	public void testCalculateError() {
		assertTrue(true);
	}

	@Test
	public void testGetFeatureValue() {
		assertTrue(true);
	}

}
