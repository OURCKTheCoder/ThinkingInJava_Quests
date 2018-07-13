public class MainConsole {
	public static void main(String[] args) {
		try{
			throw new MyE("Ex!!!!!");
		} catch(MyE e) {
			e.printStackTrace();
		}
	}
}

class MyE extends Exception{
	private String str;
	MyE(String str) { super(str); this.str = str; }
	public void show() { System.out.println(str); }
}
		
