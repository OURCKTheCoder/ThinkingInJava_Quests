import java.util.*;

public class TestMain {
	
	public static void main(String[] args) {
		Set<String> nickName = new HashSet<String>();
		nickName.add("BigFace");
		nickName.add("Apple");
		nickName.add("ZZ");
		nickName.add("Pussy");
		nickName.add("TheBlack");
		nickName.add("CAoTan");
		
		Set<String> hTable = new TreeSet<String>(nickName);
		Set<String> sorted = new LinkedHashSet<String>(hTable);
		
		System.out.println(nickName);
		System.out.println(sorted);
	}

}

