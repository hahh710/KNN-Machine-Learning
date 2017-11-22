import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	FeatureTest.class,
	TestingExampleTest.class,
	TrainingExampleTest.class,
	ExampleTest.class,
	DistanceTest.class
})

public class AllTests {

}


