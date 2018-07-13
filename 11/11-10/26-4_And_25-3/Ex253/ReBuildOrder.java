package Ex253;
import Ex264.*;
import java.util.*;

public class ReBuildOrder extends WordPosCounter{
	public ReBuildOrder(String path) {
		super(path);
	}
	public TreeMap<Integer, String> reBuildWordsOrder() {
		HashMap<String,ArrayList<Integer>> wordposT = calculate();
		ArrayList<WordUnit> wus = new ArrayList<>();
		for(String str : wordposT.keySet()) {
			wus.add(new WordUnit(str, wordposT.get(str)));
		}
		
		//Make a injective Map.
		TreeMap<Integer, String> injective = new TreeMap<>(); //injective adj.单一映射的
		for(WordUnit wu : wus) {
			injective.putAll(wu.tidyMap());//[+]既然有addAll，也应该有putALl
		}
		return injective;
	}
	public static void main(String[] args) {
		ReBuildOrder r = new ReBuildOrder("123.java");
		System.out.println(r.reBuildWordsOrder());
	}

}

class WordUnit{
	private String word;
	private ArrayList<Integer> pos;
	public WordUnit(String str, ArrayList<Integer> posList) {
		this.word = str;
		this.pos = posList;
	}
	public String toString() { return word; }
	public Map<Integer, String> tidyMap(){
		HashMap<Integer, String> m = new HashMap<Integer, String>();
		for(Integer i : pos) {
			m.put(i, word);
		}
		return m;
	}
}

