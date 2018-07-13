package ourck.mainconsole;

import java.util.*;

public class TestMain {
	
	public static void main(String[] args) {
		Map<String, String> nickName = new HashMap<String, String>();
		nickName.put("BigFace", "bigf");
		nickName.put("Apple", "LHY");
		nickName.put("ZZ", "OURCK");
		nickName.put("Pussy", "Cat");
		nickName.put("TheBlack", "LHM");
		nickName.put("CAoTan", "CHD");
		
		Set<String> hTable = new TreeSet<String>(nickName.keySet());
		Map<String, String> sorted = new LinkedHashMap<String, String>();
		for(String head : hTable) { //Iterates by dictionary order.
			String newVal = nickName.get(head);
			sorted.put(head, newVal);
		}
		
		System.out.println(nickName);
		System.out.println(sorted);
	}

}

