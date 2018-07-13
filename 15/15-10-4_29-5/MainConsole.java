package ourck.mainconsole;

import java.util.*;

public class MainConsole {
	
	public void test(Holder<List<?>> hd) {
		hd.set(new ArrayList<Integer>());
		hd.set(new ArrayList<Object>());
		hd.set(new ArrayList());

		List<?> lst = hd.get();
//		List<Object> lst1 = hd.get();
		List<? extends Object> lst2 = hd.get(); // Erase to the bound.(Object)

	}
	
	public static void main(String[] args) {
		
	}
	
}

