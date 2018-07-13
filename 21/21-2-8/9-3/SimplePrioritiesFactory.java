import java.util.concurrent.*;

public class SimplePrioritiesFactory {
	private int priority;
	public SimplePrioritiesFactory(int priority) {
		this.priority = priority;
	}
	public Thread smpFactory(Runnable r) {
		Thread smp = new Thread(r);
		smp.setPriority(priority);
		return smp;
	}

	public static void main(String[] args) {
		SimplePrioritiesFactory smpf = 
			new SimplePrioritiesFactory(Thread.MIN_PRIORITY);
		smpf.smpFactory(new SimplePriorities()).start();
	}
	
}
