import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class TestingExample extends TrainingExample {

	private Distance distances;
	private Feature feature;
	private KNN knn;
	private int k;
	private Example exampleManager;

	public TestingExample(Feature feature, int k, Example eM) {
		this.k = k;
		this.feature = feature;
		exampleManager = eM;
	}
	public void updateDistances(){
		Distance.update();
	}
	
	public void PredictFeature(Feature F){

		//sujective f
		if(exampleManager.checkSubjective(F)){
			//feaure.setname(distance.getdistances(F));
			//
		}
		if(exampleManager.checkAbsolute(F)){
			//distance.getEucleadianaverage(F);
			//feature.setNumValue(//dsitanceaverage);
		}
		if(exampleManager.checkEuclidean(F)){
			//distance.getEucleadianAverage(F);
			//feature.setCorX(distance.getXaverage);
		}

	}
}