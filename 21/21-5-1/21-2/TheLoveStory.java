package ourck.mainconsole;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TheLoveStory {
	public static void main(String[] args) throws InterruptedException {
		Princess rose = new Princess();
		
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(rose);
		exec.execute(new Hero(rose));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
}

class Princess implements Runnable {
	public void run() {
		try {
			waiting();
		} catch (InterruptedException e) {
			System.err.println("Princess: I can't wait any more!");
		}
	}
	public synchronized void waiting() throws InterruptedException {
		System.out.println("Princess: My hero, whre are you?");
		wait();
		System.out.println("Princess: It's you! My hero!");
	}
}

class Hero implements Runnable {
	Princess princess; // Try AOP?
	public Hero(Princess theOneBeloved) { princess = theOneBeloved; } // DI
	public void run() {
		synchronized(princess) {
			searching();
			princess.notifyAll();
			System.out.println("Hero: It's you! My ROSE!");
		}
	}
	public void searching() {
		System.out.println("Hero: I'm searching for her...");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			System.err.println("Hero: Still can't find her...");
		}
	}
}