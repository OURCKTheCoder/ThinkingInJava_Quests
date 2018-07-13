public class MultiDimensionAry {
	public static void main(String[] args) {
		int[][] ary1 = {
			{0,1,2,3,4,5},
			{6,7,8,9,10,11}
		};
		int[][] ary2 = {
			{0,1,2,3,4,5},
			{6,7,8,9,10,11}
		};
		int[][] ary3 = {
			{0,1,2,3,4,5},
			{6,7,8,9,10,55441}
		};
		
		System.out.println(ary1.equals(ary2));
		System.out.println(ary1.equals(ary3));
		
		//In fact...
		System.out.println(ary1[0]);
		System.out.println(ary1[1]);
		
		System.out.println();
		//deepEquals() here
		System.out.println(java.util.Arrays.deepEquals(ary1,ary2));
		System.out.println(java.util.Arrays.deepEquals(ary1,ary3));
	
		System.out.println();
		//Of course return false when comparing the two "same" object.
		A[][] a = { {new A(), new A()}, {new A(), new A()} };
		A[][] b = { {new A(), new A()}, {new A(), new A()} };
		System.out.println(java.util.Arrays.deepEquals(a,b));
	}
}

class A{}
