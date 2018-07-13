package ourck.mainconsole;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class BusyFactory2 {

	public static void main(String[] args) throws InterruptedException {
		BusyWorker2 tom = new BusyWorker2();
		
		ExecutorService e = Executors.newCachedThreadPool();
		e.execute(new Boss2(tom));
		e.execute(tom);
		TimeUnit.SECONDS.sleep(5);
		e.shutdownNow();
	}

}

class BusyWorker2 implements Runnable {
	public AtomicBoolean inspectFlag = new AtomicBoolean(true); 
	// Must be true at first, or won't enter the "while" block
	
	public BusyWorker2() {}
	public void run() {
		while(inspectFlag.get()) {
			System.out.println("Worker: Sir! Not done yet!");
			try {
				playingGame();
			} catch (InterruptedException e) {
				System.err.println("Worker: NO! +1S PLZ!");
				break;
			}
		}
	}
	public synchronized void playingGame()
	throws InterruptedException {
		wait();
	}
}

class Boss2 implements Runnable {
	private BusyWorker2 toBeInspected;
	public Boss2(BusyWorker2 w) { toBeInspected = w; }
	public void run() {
		while(!Thread.interrupted()) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				System.err.println("Boss: YOU'RE FIRED!");
				break;
			}
			System.out.println("Boss: How's it going?");
			toBeInspected.inspectFlag.set(true);
			synchronized (toBeInspected) {
				toBeInspected.notify();
			}
		}
	}
}