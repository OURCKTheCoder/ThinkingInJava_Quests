package ourck.mainconsole;

import java.util.*;
import net.mindview.util.*;

public class MainConsole {
	public static void main(String[] args) {
		Generator<WhichFieldThatMatters> gen = WhichFieldThatMatters.generator();
		
		ArrayList<WhichFieldThatMatters> lst = new ArrayList<>();
		WhichFieldThatMatters[] ary = new WhichFieldThatMatters[7];
		
		for(int i = 0; i < 7; i++) ary[i] = gen.next();
		for(int i = 0; i < 7; i++) lst.add(gen.next());
		
		System.out.println(lst);
		System.out.println(Arrays.toString(ary));
		
		System.out.println("---------Sorted---------");
		
		Arrays.sort(ary);
		Collections.sort(lst);
		
		System.out.println(lst);
		System.out.println(Arrays.toString(ary));

		System.out.println("---------Now BinarySearch()---------");
		System.out.println(Arrays.binarySearch(ary,
				new WhichFieldThatMatters("test", "...", 1)));
		System.out.println(Collections.binarySearch(lst,
				new WhichFieldThatMatters("test", "...", 1)));
	
		// A success search.
		WhichFieldThatMatters[] ary2 = {
				new WhichFieldThatMatters("TEST", "TEST", 1),
				new WhichFieldThatMatters("TEST2", "TEST", 1),
				new WhichFieldThatMatters("TEST3", "TEST", 1)
		};
		System.out.println(Arrays.binarySearch(ary2,
				new WhichFieldThatMatters("TEST2", "TEST", 1)));
	}
}

class WhichFieldThatMatters implements Comparable<WhichFieldThatMatters>{
	private static Random rand = new Random(47);
	private static final int STR_SIZE = 7;
	private final String theMatterOne;
	private String str1;
	private String str2;
	
	public WhichFieldThatMatters(String str1, String str2, int matter) {
		this.str1 = str1;
		this.str2 = str2;
		if(matter == 1) theMatterOne = str1;
		else if(matter == 2) theMatterOne = str2;
		else {
			System.err.println(" [!] Invalid input! str1 matters! ");
			theMatterOne = str1;
		}
	}
	
	public WhichFieldThatMatters(int matter) {
		StringBuilder stb1 = new StringBuilder();
		StringBuilder stb2 = new StringBuilder();

		for(int i = 0; i < STR_SIZE; i++) {
			stb1.append((char)(rand.nextInt(26) + 'A'));
			stb2.append((char)(rand.nextInt(26) + 'A'));
		}
		str1 = stb1.toString(); str2 = stb2.toString();

		if(matter == 1) theMatterOne = str1;
		else if(matter == 2) theMatterOne = str2;
		else {
			System.err.println(" [!] Invalid input! str1 matters! ");
			theMatterOne = str1;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof WhichFieldThatMatters)) return false; 
		return theMatterOne == ((WhichFieldThatMatters)obj).theMatterOne;
	}
	
	@Override
	public int hashCode() {
		return theMatterOne.hashCode();
	}
	
	
	@Override
	public int compareTo(WhichFieldThatMatters o) {
		return String.CASE_INSENSITIVE_ORDER.compare(theMatterOne, o.theMatterOne);
		// TODO If str == null ?
	}
	
	@Override
	public String toString() { return theMatterOne; }
	
	public static Generator<WhichFieldThatMatters> generator() {
		return new Generator<WhichFieldThatMatters>() {
			private RandomGenerator.String strgen = new RandomGenerator.String();
			@Override
			public WhichFieldThatMatters next() {
				return new WhichFieldThatMatters(strgen.next(), strgen.next(), 1);
			}
		};
	}
	
}
