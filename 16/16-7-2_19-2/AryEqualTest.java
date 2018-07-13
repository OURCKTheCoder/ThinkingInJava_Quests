public class AryEqualTest {
	public static void main(String[] args) {	
		A[] ary1 = { new A(1), new A(2), new A(3), new A(4) };
		A[] ary2 = { new A(1), new A(2), new A(3), new A(4) };
		System.out.println(ary1.equals(ary2));
		//In fact...
		System.out.println((new A(7)).equals(new A(7)));
	
		//When using the overloaded version....
		System.out.println((new A(7)).overloadedEquals(new A(7)));
		
	}
}

class A {
	private int i;
	A(int val) { i = val; }
	public boolean overloadedEquals(A obj) {
		return obj.i == this.i;
	}
}
