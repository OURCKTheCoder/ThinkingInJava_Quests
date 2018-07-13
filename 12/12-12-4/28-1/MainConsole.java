public class MainConsole {
	public static void main(String[] args) {
		throw new MyE("Ex!!!!!");
	}
}

class MyE extends RuntimeException{
	private String str;
	MyE(String str) { super(str); this.str = str; }
	public void show() { System.out.println(str); }
}
		
