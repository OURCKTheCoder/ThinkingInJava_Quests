
import java.util.Arrays;

public class MainConsole {
	public static void main(String[] args) {	
		A[] ary = { new A(12), new A(56), new A(64), new A(14), new A(324), new A(15), 
				new A(7), new A(3), new A(98), new A(32) };
		Arrays.sort(ary);
		System.out.println(Arrays.toString(ary));
		System.out.println(Arrays.binarySearch(ary, new A(32)));
	}
}

class A implements Comparable<A>{ // A comparable object ary.
	private int i;
	A(int val) { i = val; }
	@Override
	public boolean equals(Object obj) {
		try {
			return ((A)obj).i == this.i;
		} catch (ClassCastException e) {
			System.err.println(" [!] A only can compare to A!!!!");
			throw new RuntimeException(e);
		}
	}
	@Override
	public int compareTo(A o) {
		return this.i <  o.i ? -1 : (this.i == o.i ? 0 : 1) ;
	}
	@Override
	public String toString() { return ""+i; }
}
