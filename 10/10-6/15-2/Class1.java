public class Class1{
	Class1(int val) { System.out.println(val); }
	
	public	static void main(String[] args){
		Class2 c2 = new Class2();
		c2.test();
	}
}

class Class2{
	Class1 test(){
		class Child extends Class1{
			Child(int val){
				super(7);
			}
		}
		return new Child(7){
			void fun() { System.out.println("fun!"); };
		};
	}
}
