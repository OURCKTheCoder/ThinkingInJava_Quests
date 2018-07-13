public class TestMain{
	
	private static void test(Parent obj){
//	((Child)obj).show();
		obj.show();
	}
	
	public static void main(String[] args){
		Child c = new Child();
		test(c);	
	}

}

abstract class Parent{

	abstract void show();

}

class Child extends Parent{
	
	void show(){
		System.out.println("I'm a child!");
	}

}


