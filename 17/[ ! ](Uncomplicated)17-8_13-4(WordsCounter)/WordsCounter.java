import java.io.IOException;
import net.mindview.util.*;

public class WordsCounter {
	private TextFile txtfile;
	private AssociativeArray<String, Integer> wordsMap;
	public WordsCounter(String path, int maxnum) {
		try {
			txtfile = new TextFile(path);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		wordsMap = new AssociativeArray<String, Integer>(maxnum);
		for(String word : txtfile.toString().split(" ")) {
			if(wordsMap.get(word) == null) {
				wordsMap.put(word, 1);
			}
			else {
				Integer i = wordsMap.get(word); i++; // Why it's not ByRef????
			}
		}
	}
	public String toString() {
		return wordsMap.toString();
	}
	
	public static void main(String[] args) throws IOException {
		if(args.length == 1) {
			WordsCounter w = new WordsCounter(args[0], 30);
			System.out.println(w);
		}
		else {
			throw new IOException(" [!] Plz give a valid path!");
		}
	}
}
