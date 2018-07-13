import java.util.concurrent.*;
import java.util.concurrent.locks.*;

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
	private Lock lock = new ReentrantLock();
	
	private void fun1() {
		lock.lock();
		try{
			System.out.println("fun1() begins...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println(" - fun1() ends!");
		} catch(InterruptedException e) {}
		finally {lock.unlock();}
	}
	
	private void fun2() {
		lock.lock();
		try{
			System.out.println("fun2() begins...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println(" - fun2() ends!");
		} catch(InterruptedException e) {}
		finally {lock.unlock();}
	}
	
	private void fun3() {
		lock.lock();
		try{
			System.out.println("fun3() begins...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println(" - fun3() ends!");
		} catch(InterruptedException e) {}
		finally {lock.unlock();}
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			fun1(); fun2(); fun3(); // Test atomicity.
		}
	}
}
