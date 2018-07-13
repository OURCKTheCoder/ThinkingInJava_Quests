import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class MainConsole {
	public static void main(String[] args)
	throws InterruptedException {
		for(int i = 0; i < 5; i++) new Sensor();
		ExecutorService exec = Executors.newCachedThreadPool();
		for(Sensor s : Sensor.getSensorsList()) {
			exec.execute(s);
		}
		TimeUnit.SECONDS.sleep(3); // RUn for a while
		Sensor.cancel();
		exec.shutdown();
	}
}

class Sensor implements Runnable {
	private static List<Sensor> sensors = new ArrayList<>();
	private AtomicInteger counter = new AtomicInteger(0);
	private static AtomicInteger total = new AtomicInteger(0);
	private static boolean canceled;
	public Sensor() {
		sensors.add(this);
	}
	public void run() {
		while(!canceled) {
			synchronized(this) { // Maybe useless: multi-task instead of multi-thread
				counter.addAndGet(1);
				total.addAndGet(1);
//				try{
//					TimeUnit.MILLISECONDS.sleep(100);
//					Thread.yield();
//				} catch(InterruptedException e) {}
			}
			System.out.println(this + ": " + counter.get()
											+ ", Total: " + total.get());
			try{
				TimeUnit.MILLISECONDS.sleep(100);
			} catch(InterruptedException e) {}
		}
	}
//	public int getVal() { return counter.get(); }
//	public static int getTotal() { return total.get(); }
	public static List<Sensor> getSensorsList() { return sensors; }
	public static void cancel() { canceled = true; }
}
