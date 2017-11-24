import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FloatFeatureTest {
	float v1=10;
	float v2=15;
	String s1="new1";
	String s2="new2";
	FloatFeature f1;
	FloatFeature f2;
	String m1="absoluteDistance";
	String m2="SquareDistance";

	@Before
	public void setUp() throws Exception {
	 f1= new FloatFeature(s1,v1);
	 f2=new FloatFeature(s2,v2);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDistance() {
		f1.getDistance(f2, m1);
	}

	@Test
	public void testFloatFeature() {
		
		assertEquals(new FloatFeature(s1,v1),f1);
	}

	@Test
	public void testAbsoluteDistance() {
		fail("Not yet implemented");
	}

	@Test
	public void testSquareDistance() {
		fail("Not yet implemented");
	}

	@Test
	public void testSubValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValue() {
		fail("Not yet implemented");
	}

}
