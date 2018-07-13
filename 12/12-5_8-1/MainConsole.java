public class MainConsole {
	public static void main(String[] args) {
		MainConsole m = new MainConsole();
		try{
			m.testEx();
		}
		catch(MyE e) {
			e.printStackTrace();
		}
		
	}
	public void testEx() throws MyE{
//		try{
			throw new MyE("Ex!!!!!");
//		}	
	}
}

class MyE extends Exception{
	private String str;
	MyE(String str) { super(str); this.str = str; }
	public void show() { System.out.println(str); }
}
		
