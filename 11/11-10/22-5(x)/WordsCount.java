
import java.util.*;
import net.mindview.util.*;

public class WordsCounter {
	
	private String path;
	private List<String> words;
	private Set<WordElement> wTable = new TreeSet<WordElement>();
	
	public WordsCounter(String path) {
		this.path = path;
		words = new ArrayList<String>(new TextFile(this.path, "\\W+"));
	}
	
	public Set<WordElement> calculate() {

		 for(String word : words) {
			
		 }
	}
	
	public static void main(String[] args) {
		WordsCounter w = new WordsCounter("123.java");
		Map<String, Integer> rst = w.calculate();
		System.out.println(rst);
		
		//TODO Copy to a Set
			
	}

}

class WordElement{
	private String word;
	private Integer count;
	WordElement(String word, Integer count){
		this.word = word;
		this.count = count;
	}
	public String toString() { return word; }
	public Integer getCount() { return count; }
}

