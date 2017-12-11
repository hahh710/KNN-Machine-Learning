import static org.junit.Assert.*;

import java.util.HashMap;

import javax.swing.DefaultListModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TrainingExampleTest {
	private String exampleName;
	private HashMap<String, Feature> feature;
	private DefaultListModel<String> nameSet;

	@Before
	public void setUp() throws Exception {
		exampleName = new String();
		feature = new HashMap<String, Feature>();
		nameSet = new DefaultListModel<String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTrainingExample() {
		assertNotNull("exampleName is not null", exampleName);
		assertNotNull("feature is not null", feature);
		assertNotNull("nameSet is not null", nameSet);
	}

	public void createExample() {
		assertNotNull("exampleName is not null", exampleName);
		assertNotNull("feature is not null", feature);
		assertNotNull("nameSet is not null", nameSet);
	}

	public void testaddFeature() {

	}

	public void testgetFeature() {

	}

	public void testremoveFeature() {

	}

	public void testgetExampleName() {

	}

	public void testcheckKeyName() {

	}

	public void testgetKeyName() {

	}

	public void testgetNameSet() {

	}

	public void testgetAllFeatures() {

	}

	public void testsetFeatures() {

	}

	public void testgetTrainingExampleName() {

	}

	public void testsetTrainingExampleName() {

	}

	public void testtoString() {

	}

}
