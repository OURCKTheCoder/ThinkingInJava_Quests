import java.util.*;
import net.mindview.util.*;

public class VowelsSet {

	public static void main(String[] args) {
		Set<String> s = new HashSet<String>( // Or TreeSet for an ordered Set.
			new	TextFile("UniqueWords.java", "\\W+"));
		System.out.println(s);
		
		Set<Character> vowels = new HashSet<>();
		Collections.addAll(vowels, 'A','E','I','O','U','a','e','i','o','u');
		
		String[] res = (String[]) s.toArray(new String[s.size()]);//参数是什么意思？
		int i = 0;
		/*  
		 * 1.可以直接for(String str : s) 从而省去上面那句把Set转换成Ary的过程。
		 * 2.拆词可以用迭代器
		 */
		for(String str : res) { 
			for(char c : str.toCharArray()) {
//				switch (c) {
//				case 'a': case 'A':
//				case 'e': case 'E':
//				case 'i': case 'I':
//				case 'o': case 'O':
//				case 'u': case 'U':		i++;
//										break;
//				}
				//3.最好使用contain()方法:把元音作为另一份Set，元音表.containAll(目标字符)。
				if(vowels.contains(c)) i++;
			}
		}
		System.out.println(i);
	}

}

