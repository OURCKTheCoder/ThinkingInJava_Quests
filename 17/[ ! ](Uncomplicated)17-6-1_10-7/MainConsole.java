package ourck.mainconsole;

import net.mindview.util.*;
import java.util.*;

public class MainConsole {
	
	public static void main(String[] args) {	
		RandomGenerator.String gen  = new RandomGenerator.String();
		SortedSet<String> set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		for(int i = 0 ; i < 10; i++) set.add(gen.next());
		System.out.println(set);
	}
}