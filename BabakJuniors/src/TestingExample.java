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
	
	public void PredictFeature(Feature f){
		String fName=f.getFName();
		int count=0;
		exampleManager.getTrainingExamples();
		//sujective f
		if(exampleManager.checkSubjective(f)){
			int position=0;
			for(TrainingExample t: KNN.getNN()){
				position+=t.getAllFeatures().get(fName).getRank();
				count++;
			}
			position=position/count;
			//
			//feaure.setname(distance.getdistances(F));
			//
		}
		if(exampleManager.checkAbsolute(f)){
			int sum=0;
			for(TrainingExample t: KNN.getNN()){
				sum+=t.getAllFeatures().get(fName).getNumValue();
				count++;
			}
			sum=sum/count;
			//distance.getEucleadianaverage(F);
			//feature.setNumValue(//dsitanceaverage);
		}
		if(exampleManager.checkEuclidean(f)){
			int xSum=0;
			int ySum=0;
			for(TrainingExample t: KNN.getNN()){
				xSum+=t.getAllFeatures().get(fName).getCorX();
				ySum+=t.getAllFeatures().get(fName).getCorY();
				count++;
			}
			xSum=xSum/count;
			ySum=ySum/count;
			//distance.getEucleadianAverage(F);
			//feature.setCorX(distance.getXaverage);
		}

	}
}