import java.util.*;

public class IterableFibonacci implements Iterable<Integer> {
	private Fibonacci f = new Fibonacci();
	private int i;
	public IterableFibonacci(int val){
		i = val;
	}
	public Iterator<Integer> iterator(){
		return new Iterator<Integer>() {
			public boolean hasNext() { return i-- > 0; }
   		public Integer next() {
   			return f.next();
   		}
		};
	}
	
	public static void main(String[] args){
		IterableFibonacci i = new IterableFibonacci(7);
		for(Integer num : i){
			System.out.println(num);
		}
	}
}
