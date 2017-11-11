import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	RankTest.class,
	FeatureTest.class,
	TestingExampleTest.class,
	TrainingExampleTest.class,
	ExampleTest.class,
	DistanceTest.class,
	ExampleManagerTest.class
})

public class AllTests {

}


