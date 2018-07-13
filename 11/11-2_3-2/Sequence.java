import java.util.*;

interface Selector {
  boolean end();
  Object current();
  void next();
}	

public class Sequence {
  private ArrayList items;
//  private int next = 0;
  public Sequence() { items = new ArrayList(); } //ArrayList<Object>
  public void add(Object x) {
	items.add(x);
  }
  private class SequenceSelector implements Selector {
    private int i = 0;
    public boolean end() { return i == items.size(); }
    public Object current() { return items.get(i); }
    public void next() { if(i < items.size()) i++; }
  }
  public Selector selector() {
    return new SequenceSelector();
  }	
  public static void main(String[] args) {
    Sequence sequence = new Sequence();
    for(int i = 0; i < 10; i++)
      sequence.add(Integer.toString(i));
    Selector selector = sequence.selector();
    while(!selector.end()) {
      System.out.print((String)selector.current() + " ");//"Object" downcast to str.
      selector.next();
    }
  }
} /* Output:
0 1 2 3 4 5 6 7 8 9
*///:~

