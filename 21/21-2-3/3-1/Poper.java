package ourck.mainconsole;

public class Poper implements Runnable {
	private static int refcounter = 0;
	private final int id = refcounter++;

	private int poptimes = 3;
	private String startmsg;
	public void pop() { 
		System.out.println(id + " pop!");
	}
	public Poper(String msg) { 
		startmsg = this + " #" + id + " : \"" + msg + "\" starts!";
		System.out.println(startmsg);
	}
	public void run() {
		while(poptimes-- != 0){
			pop();
			Thread.yield();
		}
		System.out.println(this + " #" + id + " : ends!");
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			new Thread(new Poper("START_MSG")).start();
		}
	}
}
