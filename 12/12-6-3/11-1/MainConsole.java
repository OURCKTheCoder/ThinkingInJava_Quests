public class MainConsole {
	public void f() throws RuntimeException {
		try {
		   g();
		} catch (ExA e) {
		   System.out.println("ExA caught!");
			e.printStackTrace(System.out);
			System.out.println("		...And pack it as RTExp.");
			throw new RuntimeException(e);
		}
	}
	
	public void g() throws ExA {
		throw new ExA();
	}

	public static void main(String[] args) {
		MainConsole m = new MainConsole();
		try {
			m.f();
		} catch (RuntimeException e) {
			System.out.println("Ex again!!!!!!!!!!!");
			e.printStackTrace(System.out);
		}
		
	}

}

class ExA extends Exception {}

class ExB extends Exception {}
