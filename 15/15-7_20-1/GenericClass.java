public class GenericClass {
	public static <T extends SampleInterface> void test(T obj) {
		obj.foo();
		obj.bar();
//		obj.fun();		
	} 
	
	public static void main(String[] args) {
		test(new SampleClass(){
			public void foo() { System.out.println("foo!"); }
			public void bar() { System.out.println("bar!"); }
			public void fun() { System.out.println("写了也没鸟用"); }
		});
	}
}
