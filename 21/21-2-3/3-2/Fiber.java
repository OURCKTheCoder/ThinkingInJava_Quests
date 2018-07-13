package ourck.mainconsole;

import net.mindview.util.*;

public class Fiber implements Runnable{
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

class Fibonacci implements Generator<Integer> {
  private int count = 0;
  public Integer next() { return fib(count++); }
  private int fib(int n) {
    if(n < 2) return 1;
    return fib(n-2) + fib(n-1);
  }
  public static void main(String[] args) {
    Fibonacci gen = new Fibonacci();
    for(int i = 0; i < 18; i++)
      System.out.print(gen.next() + " ");
  }
}
