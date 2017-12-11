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
	FloatFeature fTest;
	String iD= "ID";

	@Before
	public void setUp() throws Exception {
		f1 = new FloatFeature(s1, v1);
		f2 = new FloatFeature(s2, v2);
		fTest = new FloatFeature(s1, v1);

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

		assertTrue(fTest.getFName().equals(s1));
		assertTrue(fTest.getValue() == (v1));
	}

	@Test
	public void testAbsoluteDistance() {

		assertEquals(answer, fTest.absoluteDistance(f2), f2.getValue() - answer);
	}

	@Test
	public void testSquareDistance() {
		assertEquals(answerSq, fTest.squareDistance(f2), f2.getValue() - answer);
	}

	@Test
	public void testSubValue() {
		assertEquals(answer, fTest.subValue(f2), f2.getValue() - answer);
	}

	@Test
	public void testSetValue() {
		fTest.setValue(answer);
		assertEquals(answer, fTest.getValue(), fTest.getValue() - answer);
	}

	@Test
	public void testGetValue() {
		assertEquals(answer, f1.getValue(), f1.getValue() - answer);
	}

}
