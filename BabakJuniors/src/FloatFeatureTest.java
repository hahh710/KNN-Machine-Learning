import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FloatFeatureTest {
	float v1 = 10;
	float v2 = 15;
	String s1 = "new1";
	String s2 = "new2";
	FloatFeature f1;
	FloatFeature f2;
	String m1 = "absoluteDistance";
	String m2 = "SquareDistance";
	float answer = 5;
	float answerSq = 125;

	@Before
	public void setUp() throws Exception {
		f1 = new FloatFeature(s1, v1);
		f2 = new FloatFeature(s2, v2);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDistance() {
		assertEquals(answer, f1.getDistance(f2, m1), v2 - answer);

	}

	@Test
	public void testFloatFeature() {
		FloatFeature fTest = new FloatFeature(s1, v1);
		assertTrue(fTest.getFName().equals(s1));
		assertTrue(fTest.getValue() == (v1));
	}

	@Test
	public void testAbsoluteDistance() {
		FloatFeature fTest = new FloatFeature(s1, v1);
		assertEquals(answer, fTest.absoluteDistance(f2), f2.getValue() - answer);
	}

	@Test
	public void testSquareDistance() {
		FloatFeature fTest = new FloatFeature(s1, v1);
		assertEquals(answerSq, fTest.squareDistance(f2), f2.getValue() - answer);
	}

	@Test
	public void testSubValue() {
		FloatFeature fTest = new FloatFeature(s1, v1);
		assertEquals(answer, fTest.subValue(f2), f2.getValue() - answer);
	}

	@Test
	public void testSetValue() {
		FloatFeature fTest = new FloatFeature(s1, v1);
		fTest.setValue(answer);
		assertEquals(answer, fTest.getValue(), fTest.getValue() - answer);
	}

	@Test
	public void testGetValue() {
		assertEquals(answer, f1.getValue(), f1.getValue() - answer);
	}

}
