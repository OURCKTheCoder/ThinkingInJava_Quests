
import java.util.*;
import net.mindview.util.*;

public class WordsCounter {
	
	private String path;
	private List<String> words;
	private Map<String, Integer> unsorted = new TreeMap<>();
	
	public WordsCounter(String path) {
		this.path = path;
		words = new ArrayList<String>(new TextFile(this.path, "\\W+"));
	}
	
	public Map<String, Integer> calculate() {

		 for(String word : words) {
			 Integer count = unsorted.get(word);
			 if(count == null) 
				 count = 1;
			 else
				 count++;
			 unsorted.put(word, count);
		 }
		 return unsorted;
	}
	
	public static void main(String[] args) {
		WordsCounter w = new WordsCounter("123.java");
		Map<String, Integer> rst = w.calculate();
		System.out.println(rst);
		
		//TODO 产生字母序Map
		List<String> headT = new ArrayList<>();
		for(String head : rst.keySet()) {
			headT.add(head);
		}

		Collections.sort(headT, String.CASE_INSENSITIVE_ORDER);
		/*[!]关于String.CASE_INSENSITIVE_ORDER
		 * 
		 * 这个排序其实并不是明确的字母顺序：
		 * 正常来说不管一个单词长度如何，应该只按照首字母排序。
		 * 这个却连长度也考虑进去了。
		 */
		Map<String, Integer> sorted = new LinkedHashMap<String, Integer>();
		for(String str : headT) {
			sorted.put(str ,rst.get(str));
		}
		
		System.out.println(sorted);
	}

}

