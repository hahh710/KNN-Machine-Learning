
public class testy {

	public static void main(String[] args) {
		TrainingExample example = new TrainingExample("test");
		CompositeFeature ball =  new  CompositeFeature("Ball");
		
		Feature distance = new FloatFeature("Distance",(float) 1.9);
		ball.addFeature(distance);
		Feature Direction = new FloatFeature("Direction",(float) 1.9);
		ball.addFeature(Direction);
		
		
		Feature goal = new CompositeFeature("Goal");
		Feature distance = new FloatFeature("Distance",(float) 1.9);
		Feature Direction = new FloatFeature("Direction",(float) 1.9);
		
			
	}

}
