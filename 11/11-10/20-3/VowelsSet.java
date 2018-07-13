package ourck.mainconsole;

import java.util.*;
import net.mindview.util.*;

public class VowelsSet {

	public static void main(String[] args) {
		Set<String> s = new HashSet<String>(
			new	TextFile("UniqueWords.java", "\\W+"));
		System.out.println(s);
		
		Set<Character> vowels = new HashSet<>();
		Collections.addAll(vowels, 'A','E','I','O','U','a','e','i','o','u');
		
		Map<Character, Integer> nVowel = new HashMap<Character, Integer>();
		int i = 0;
		/*  
		 * 1.拆词可以用迭代器
		 */
		for(String str : s) { 
			for(char c : str.toCharArray()) {
//				switch (c) {
//				case 'a': case 'A':
//				case 'e': case 'E':
//				case 'i': case 'I':
//				case 'o': case 'O':
//				case 'u': case 'U':		i++;
//										break;
//				}
				//2.最好使用contain()方法:把元音作为另一份Set，元音表.contain(目标字符)。
				if(vowels.contains(c)){
					//i++; //Count all.
					Integer originNum = nVowel.get(c); //Cannot be "int"! "int" obj cannot receive a null return.
					if(originNum == null) originNum = 1;
					nVowel.put(c,++originNum);
				}
			}
		}
		System.out.println(nVowel);
	}

}

