public class SequenceTest{
  public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for(int i = 0; i < 10; i++)
		  sequence.add(Integer.toString(i));
		
		Selector selector = sequence.getSeqSelector();
		Selector selector2 = sequence.getRevSelector();
		
		while(!selector.end()) {
		  System.out.print(selector.current() + " ");
		  selector.next();
		}
		
		while(!selector2.end()){
		  System.out.print(selector2.current() + " ");
		  selector2.next();
		}
   }
}

interface Selector {
  boolean end();
  Object current();
  void next();
}	

class Sequence {
  private Object[] items;
  private int next = 0;
  
  public Sequence(int size) { items = new Object[size]; }
  public void add(Object x) {
    if(next < items.length)
      items[next++] = x;
  }
  
  private class SequenceSelector implements Selector {
    private int i = 0;
    public boolean end() { return i == items.length; }
    public Object current() { return items[i]; }
    public void next() { if(i < items.length) i++; }
  }
  
  public Selector getSeqSelector() {
    return new SequenceSelector();
  }
  
  private class ReverseSelector implements Selector{
	private int i = items.length - 1;
	public boolean end() { return i == 0; }
	public Object current() { return items[i]; }
	public void next() { if(i > 0) i--; }  
  }
  
  public Selector getRevSelector(){
  	return new ReverseSelector();
  }
} 
