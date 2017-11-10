import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class TestingExample extends TrainingExample {

	private Distance distances;
	private Feature feature;
	private KNN knn;
	private int k;
	private Example examplemanager;

	public TestingExample(Feature feature, int k, Example eM) {
		this.k = k;
		this.feature = feature;
		examplemanager = eM;
	}



}
