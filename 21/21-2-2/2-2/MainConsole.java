public class MainConsole{
	public static void main(String[] args) {
		Fiber f = new Fiber(7);
		for(int i = 0; i < 10; i++) {
			System.out.print(f.next() + " ");
		}
		System.out.println();
		System.out.println("----------------------------");
		for(int i = 0; i < 10; i++) {
			new Thread(new Fiber(i)).start();
		}
	}
}

class Fiber implements Runnable{
	private static int refcounter = 0;
	private final int id = refcounter++;
	private Fibonacci fiber = new Fibonacci();
	private int fibsize;
	public Fiber(int fibsize){
		this.fibsize = fibsize;
		System.out.println("Fiber " + id + " Constructed with a size of " + fibsize);
	}
	public void run() {
		while(fibsize-- > 0) {
			System.out.print(fiber.next() + " ");
		}
		System.out.println();
	}
	public int next() { return fiber.next(); }
}
