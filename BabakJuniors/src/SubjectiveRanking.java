import java.util.ArrayList;

//This Rank class is for subjective Rank system.
public class SubjectiveRanking {
	private String nameOfFeatureRank;
	private ArrayList<String>rankingOfFeature;
	
	public SubjectiveRanking(String fName){
		nameOfFeatureRank=fName;
		rankingOfFeature = new ArrayList<String>();
	}
	/**addToSubjectiveRanking
	 * 
	 * @param s the String to be added to Subjective Ranking
	 */
	public void addToSubjectiveRanking(String s) {
		rankingOfFeature.add(s);
	}
	/**getRank
	 * 
	 * @param s
	 * @return the first index of a given string in the ranking list
	 */
	public int getRank(String s) {
		int index=0;
		for(String str:rankingOfFeature) {
			if(s.equalsIgnoreCase(str)) 
				return index;
			index++;
		}
		return 0;
	}
	public String getStringValueAtRank(int i) {
		return rankingOfFeature.get(i);
	}
	/**
	 * getRankingListType
	 * @return the type of string ranking that this is
	 */
	public String getRankingListType() {
		return nameOfFeatureRank;
	}
/**
	public boolean checkName(String name){
		if(this.name == name) return true;
		else return false;
	}
	/**getRankingList
	 * 
	 * @return the list of
	 */

	/**getValueAtRank
	 * 
	 * @param r
	 * @return the actual string of a particular rank, aka string at position
	 */
	/**
	 *
	public String getValueAtRank(int r){
		return list.get(r).getStringValue();
	}
*/
}
