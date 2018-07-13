import java.util.concurrent.*;

public class MainConsole {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		SampleThread t = new SampleThread();
		for(int i = 0; i < 10; i++) {
			exec.execute(t);
		}
		exec.shutdown();
	}
}

class SampleThread implements Runnable {
	private Object monitor = new Object(); // Try adding other monitors.
	
	private void fun1() {
		synchronized(monitor) {
			try{
				System.out.println("fun1() begins...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println(" - fun1() ends!");
			} catch(InterruptedException e) {}
		}
	}
	
	private void fun2() {
		synchronized(monitor) {
			try{
				System.out.println("fun2() begins...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println(" - fun2() ends!");
			} catch(InterruptedException e) {}
		}
	}
	
	private void fun3() {
		synchronized(monitor) {
			try{
				System.out.println("fun3() begins...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println(" - fun3() ends!");
			} catch(InterruptedException e) {}
		}
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			fun1(); fun2(); fun3(); // Test atomicity.
		}
	}
}
