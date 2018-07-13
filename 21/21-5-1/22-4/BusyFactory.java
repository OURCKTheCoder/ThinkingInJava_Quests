package ourck.mainconsole;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class BusyFactory {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService e = Executors.newCachedThreadPool();
		e.execute(new Boss());
		e.execute(new BusyWorker());
		TimeUnit.SECONDS.sleep(5);
		e.shutdownNow();
	}

}

class BusyWorker implements Runnable {
	public static AtomicBoolean inspectFlag = new AtomicBoolean(false);
	public void run() {
		while(!Thread.interrupted()) {
			if(inspectFlag.get()) {
				inspectFlag.set(false);
				System.out.println("Worker: Sir! Not done yet!");
			}
		}
	}
}

class Boss implements Runnable {
	public void run() {
		while(!Thread.interrupted()) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				System.err.println("Boss: YOU'RE FIRED!");
				break;
			}
			System.out.println("Boss: How's it going?");
			BusyWorker.inspectFlag.set(true);
		}
	}
}