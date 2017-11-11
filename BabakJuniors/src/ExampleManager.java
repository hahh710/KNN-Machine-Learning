import java.util.ArrayList;

public class ExampleManager {
	ArrayList<Example>trainingExamples;
	//ArrayList<TestExample>TestExamples;
	ArrayList<String>type;
	//ArrayList<ArrayList<String>>rank;
	ArrayList<Rank> rank;
	//ArrayList<String>rank;//Rank for subjective features
	
	public ExampleManager(){
		trainingExamples = null;
		type = null;
		rank = null;
	}
	
	public void createTrainingExamplesSet(){
		trainingExamples = new ArrayList<Example>();
		type = new ArrayList<String>();
		rank = new ArrayList<Rank>();
	}
	
	public void addTrainingExample(Example example){
		trainingExamples.add(example);
		abstractkey(example);
	}
	
	public void abstractkey(Example example){
		for(int i = 0;i < example.getNameSet().size();i++){
			if(!type.contains(example.getNameSet().get(i))){
				if(checkSubjective(example.getFeature(example.getNameSet().get(i))) && rank.isEmpty()){
					createType(example.getKeyName(example.getFeature()),example.getFeature());
					type.add(example.getNameSet().get(i));
				}else if (checkSubjective(example.getFeature(example.getNameSet().get(i)))&& !rank.isEmpty()){
					appendFeatureInRank(example.getKeyName(example.getFeature()),example.getFeature())
					type.add(example.getNameSet().get(i));
				}else{
					type.add(example.getNameSet().get(i));
				}
			//}// else print error message that there is exist name;
		}
			
			
			
			/*
			if(type.isEmpty()){
				if(checkSubjective(example.getFeature(example.getNameSet().get(i)))){
					//rank.add(example.getNameSet().get(i));
					type.add(example.getNameSet().get(i));
				}else type.add(example.getNameSet().get(i));
			}else if(!type.contains(example.getNameSet().get(i))){
				if(checkSubjective(example.getFeature(example.getNameSet().get(i)))){
					type.add(example.getNameSet().get(i));
				}else type.add(example.getNameSet().get(i));
			}*/// else print error message that there is exist name;
		}
	}
	
	public void createType(String featureName,Feature feature){
		boolean flag = true;
		for(int i = 0; i< rank.size() ;i++){
			if(rank.get(i).checkName(featureName)){
				flag = false;
			}
		}
		if(flag){
			rank.add(new Rank(featureName,feature));
		}else{
			System.out.println("There is existing feature Name");
		}		
	}
	public void appendFeatureInRank(String featureName,Feature feature){
		for(int i = 0; i< rank.size() ;i++){
			if(rank.get(i).checkName(featureName)){
				if(!rank.get(i).getlist().contains(feature)){
					rank.get(i).getlist().add(feature);
				}
			}
		}
	}
	public boolean checkSubjective(Feature feature){
		if(feature.getStringValue() !=null) return true;
		else return false;
	}
}
