package package1;
import interface1.*;

public class TestMain implements IntSample{

	public void foo(){
		System.out.println("foo!");
	}
	
	public void bar(){
		System.out.println("bar");
	}
	
	public void fun(){
		System.out.println("fun!");
	}
	
	public static void main(String[] args){
		TestMain t = new TestMain();
		t.foo(); t.bar(); t.fun();
	}
	
}
