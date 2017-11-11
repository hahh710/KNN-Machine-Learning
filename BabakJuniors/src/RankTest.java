import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class RankTest {
	Rank rank;
	Feature feature;
	

	@Before
	public void setUp() throws Exception {
		feature = new Feature("test");
		rank = new Rank("Name", feature);
		
		//rank = new Rank(test);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRank() {
		assertNotNull("Address rank class is not null", rank);

	}

	@Test
	public void test() {
		
	}

	
	

}