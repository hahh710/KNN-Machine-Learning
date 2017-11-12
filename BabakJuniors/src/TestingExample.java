

public class TestingExample extends TrainingExample {

	private Distance distances;
	private Feature feature;
	private KNN knn;
	private int k;
	private Example exampleManager;

	public TestingExample(Feature feature, int k, Example eM) {
		this.setK(k);
		this.feature = feature;
		exampleManager = eM;
		distances=new Distance(this);
		knn = new KNN(k, this);
	}
	public Distance getDistances(){
		return distances;
	}
	public Example getExample(){
		return exampleManager;
	}
	public void PredictFeature(Feature f) {
		String fName = f.getFName();
		int count = 0;
		distances.updateDistances();
		knn.getNN();
		exampleManager.getTrainingExamples();
		// Subjective f
		if (exampleManager.checkSubjective(f)) {
			int position = 0;
			for (TrainingExample t :knn.getNN()) {
				position += t.getAllFeatures().get(fName).getRank();
				count++;
			}
			position = position / count;
			//getValueAtRank(position)
			
			feature.setStringValue(feature.getRankList().getValueAtRank(position));
			//
		}
		if (exampleManager.checkAbsolute(f)) {
			int sum = 0;
			for (TrainingExample t : knn.getNN()) {
				sum += t.getAllFeatures().get(fName).getNumValue();
				count++;
			}
			sum = sum / count;
			feature.setNumValue((float) sum);
		}
		if (exampleManager.checkEuclidean(f)) {
			int xSum = 0;
			int ySum = 0;
			for (TrainingExample t : knn.getNN()) {
				xSum += t.getAllFeatures().get(fName).getCorX();
				ySum += t.getAllFeatures().get(fName).getCorY();
				count++;
			}
			xSum = xSum / count;
			ySum = ySum / count;

			feature.setCorX(xSum);
			feature.setCorY(ySum);
		}

	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
		knn.setK(k);
	}
}