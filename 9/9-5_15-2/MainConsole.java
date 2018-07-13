package ourck.mainconsole;

interface Root1{
	void foo();
	void bar();
}

interface Root2{
	void fun();
	void wow();
}

interface Root3{
	String txt();
	Integer num();
}

interface Party extends Root1, Root2, Root3{
	void show();
}

abstract class Parent{}

class Child extends Parent implements Party{
	public void foo() {}
	public void bar() {}
	public void fun() {}
	public void wow() {}
	public String txt() { return new String("Test Text."); }
	public Integer num() { return 7; }
	public void show() {}
}

public class MainConsole{
	public static void fun1(Root1 r) {}
	public static void fun2(Root2 r) {}
	public static void fun3(Root3 r) {}
	public static void fun4(Party party) {}
	
	public static void main(String[] args) {
		Child c = new Child();
		MainConsole.fun1(c);
		MainConsole.fun2(c);
		MainConsole.fun3(c);
		MainConsole.fun4(c);
	}
}

