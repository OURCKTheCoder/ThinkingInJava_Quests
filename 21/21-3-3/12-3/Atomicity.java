import java.util.concurrent.*;

public class Atomicity {
  int i;
  synchronized void f1() { i++; }
  synchronized void f2() { i += 3; }
  
	public static void main(String[] args) {
		ThreadSafetyChecker tc = new ThreadSafetyChecker();
		tc.check();
	}
  
} 

class ThreadSafetyChecker {
	Atomicity a = new Atomicity();
	public void check() {
		
		for(int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					a.f1();
					System.out.println(a.i);
				}
			}.start();
		}
		
		for(int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					a.f2();
					System.out.println(a.i);
				}
			}.start();
		}
		
	}
}
