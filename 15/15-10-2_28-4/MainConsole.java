class Generic1<T> {
	void receive(T arg) { System.out.println(arg); }
}

class Generic2<T> {
	T get(T arg) { return arg; }
}

public class MainConsole {
	public <T super Generic1> void test1(T arg) {}
	public <T extends Generic2> void test2(T arg) {}
	
	public static void main(String[] args) {
		MainConsole m = new MainConsole();
		m.test1(new Generic1());
		m.test2(new Generic2());
	}
	
}

