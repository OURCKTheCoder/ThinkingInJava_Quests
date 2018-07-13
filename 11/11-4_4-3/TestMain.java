package ourck.mainconsole;

import java.util.*;

public class TestMain {

	public static void main(String[] args) {
		String[] ct1;
		LinkedList<String> ct2 = new LinkedList<>();//可以不添加 显式类型参数说明？？
		HashSet<String> ct3 = new HashSet<String>();
		LinkedHashSet<String> ct4 = new LinkedHashSet<String>();
		TreeSet<String> ct5 = new TreeSet<String>();
		
		MovieGenerator mv = new MovieGenerator();
		
		ct1 = new String[] { mv.next(), mv.next() };
		ct2.add(mv.next());
		ct3.add(mv.next());
		ct4.addAll(Arrays.<String>asList(mv.next(),mv.next()));//!!Type deceleration sometimes needed.
		Collections.addAll(ct5,mv.next(),mv.next());
		
		//System.out.println(ct1);
		for(String str : ct1) {
			System.out.println(str);
		}
		System.out.println(ct2);
		System.out.println(ct3);
		System.out.println(ct4);
		System.out.println(ct5);
	}

}

class MovieGenerator{
	Collection<String> strTable = new ArrayList<String>();
	private int i = 0;
	public MovieGenerator() {
		Collections.addAll(strTable,"聲の形","花火","サヨナラの朝に","Reavenger");
	}
	public String next() {
		if(++i == strTable.size()) i = 0;
		//Collection downcast to ArrayList : "get()" method nedded.
		return ((ArrayList<String>) strTable).get(i);
	}
}
