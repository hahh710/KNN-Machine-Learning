import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	StringFeatureTest.class,
	FeatureTest.class,
	TestingExampleTest.class,
	TrainingExampleTest.class,
	ExampleTest.class,
	DistanceTest.class,
	FloatFeatureTest.class,
	CompositeFeatureTest.class,
	
})

public class AllTests {

}


