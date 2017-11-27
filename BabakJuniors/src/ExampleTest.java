import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExampleTest {
	private DefaultListModel<TrainingExample> trainingExamples;
	private ArrayList<TrainingExample> trainingExamplesModel;
	private DefaultListModel<TestingExample> testingExamples;
	private ArrayList<String> type;

	@Before
	public void setUp() throws Exception {
		trainingExamples = new DefaultListModel<TrainingExample>();
		trainingExamplesModel = new ArrayList<TrainingExample>();
		testingExamples = new DefaultListModel<TestingExample>();
		type = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExample() {

		assertNotNull("Training Example is not null", trainingExamples);
		assertNotNull("Training Example Model (ArrayList) is not null", trainingExamplesModel);
		assertNotNull("Testing Example is not null", testingExamples);
		assertNotNull("Type is not null", type);
	}

	@Test
	public void testgetTrainingExampleIndex() {

	}

	@Test
	public void testgetRankInformation() {

	}

}
