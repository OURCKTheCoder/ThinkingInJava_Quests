public class MainConsole {
	public void f() throws ExB {
		try {
		   g();
		} catch (ExA e) {
		   System.out.println("ExA caught!");
			e.printStackTrace(System.out);
			throw new ExB();		   
		}
	}
	
	public void g() throws ExA {
		throw new ExA();
	}

	public static void main(String[] args) {
		MainConsole m = new MainConsole();
		try {
			m.f();
		} catch (ExB e) {
			System.out.println("Ex again!!!!!!!!!!!");
			e.printStackTrace(System.out);
		}
		
	}

}

class ExA extends Exception {}

class ExB extends Exception {}
