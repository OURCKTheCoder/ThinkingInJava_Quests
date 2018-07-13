package ourck.mainconsole;

import java.util.*;
import net.mindview.util.Countries;

public class MainConsole {
	
	public static void main(String[] args) {	
		List<String> lst1 = new ArrayList<>(Countries.names(5));
		List<String> lst2 = new LinkedList<>(Countries.names(10).subList(3, 7));
		
		Iterator<String> it1 = lst1.iterator();
		Iterator<String> it2 = lst2.iterator();
		
		ListIterator<String> lit1 = lst1.listIterator(); 
		ListIterator<String> lit2 = lst2.listIterator(); 
				
		while(it1.hasNext()) System.out.print(it1.next() + " | ");
		System.out.println('\n');
		while(it2.hasNext()) System.out.print(it2.next() + " | ");
		System.out.println('\n');
		
		while(lit1.hasNext() & lit2.hasNext()) {
			lit1.next();
			lit1.add("+" + lit2.next());
		}
		while(lit1.hasPrevious()) lit1.previous();
		while(lit1.hasNext()) System.out.print(lit1.next() + " | ");
	}
}
