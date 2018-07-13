package concurrency;
import java.util.Random;
import java.util.concurrent.*;

class SafeTank extends Tank {
	public synchronized void validate() { super.validate(); }
	public synchronized void fill() { super.fill(); }
	public synchronized void drain() { super.drain(); }
}

public class SYN {
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(
			new MyUncaughtExceptionHandler());
		System.out.println("Press Control-C to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		
		// Safe:
		SafeTank tank = new SafeTank();
		for(int i = 0; i < 10; i++)
			exec.execute(new ConsistencyChecker(tank));
		Thread.yield();
		exec.shutdown();
		
		// Not safe:
		ExecutorService execII = Executors.newCachedThreadPool();
		Tank tankII = new Tank();
		for(int i = 0; i < 10; i++)
			execII.execute(new ConsistencyChecker(tankII));
		Thread.yield();
		execII.shutdown();
	}
} 

/* ----------------From NOSYN.java------------------------*/

// The conditions, which always must hold are the following:
// 1. If the tank is EMPTY then the current_load == 0
// 2. If the tank is LOADED then the current_load >= 0
class Tank {
	enum State { EMPTY, LOADED };
	private State state = State.EMPTY;
	private int current_load = 0;
	public void validate() {
	if((state == State.EMPTY && current_load != 0) ||
	(state == State.LOADED && current_load == 0))
		throw new IllegalStateException();
	}
	public void fill() {
		state = State.LOADED;
		Thread.yield();
		// Cause failure faster
		current_load = 10; // Arbitrary value
	}
	public void drain() {
		state = State.EMPTY;
		Thread.yield();
		current_load = 0;
	}
}

class ConsistencyChecker implements Runnable {
	private static Random rnd = new Random();
	private Tank tank;
	ConsistencyChecker(Tank tank) { this.tank = tank; }
	public void run() {
		for(;;) {
			// Decide whether to fill or drain the tank
			if(rnd.nextBoolean())
				tank.fill();
			else
				tank.drain();
			tank.validate();
		}
	}
}
