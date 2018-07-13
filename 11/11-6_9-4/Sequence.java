import java.util.*;
public class Sequence {
	private ArrayList<Object> items = new ArrayList<>();
	public Sequence(Object... res) { Collections.addAll(items, res); }
	public void add(Object x) {
		items.add(x);
	}
	public Iterator<Object> iterator(){
		return items.iterator();
	}
	
	public static void main(String[] args) {
	  Sequence sequence = new Sequence(11,12,13,14,15);
	  for(int i = 0; i < 10; i++)
	    sequence.add(Integer.toString(i));
	  Iterator<Object> selector = sequence.iterator();
	  while(selector.hasNext()) {
	    System.out.print(selector.next() + " ");
	  }
	}
} 
