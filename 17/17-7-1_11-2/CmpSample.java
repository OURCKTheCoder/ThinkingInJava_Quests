import java.util.*;

public class CmpSample implements Comparable<CmpSample> {
	private static Random rand = new Random(47); // STATIC!!!
	private Integer i = rand.nextInt(100);
	public int compareTo(CmpSample obj) {
		return i < obj.i ? -1 : ( i > obj.i ? 1 : 0);
	}
	public String toString() { return "" + i; }
	
	public static void main(String[] args) {
		List<CmpSample> tmplst = new LinkedList<CmpSample>(
			Arrays.asList(new CmpSample(),new CmpSample(),
								new CmpSample(),new CmpSample(),new CmpSample())
		);
		PriorityQueue<CmpSample> q = new PriorityQueue<>(tmplst);
		while(q.peek() != null) {
			System.out.println(q.poll());
		}
	}
}
