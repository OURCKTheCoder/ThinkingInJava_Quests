import java.util.concurrent.*;

public class AHugeTask {
	public void doIt() throws InterruptedException { TimeUnit.SECONDS.sleep(10); }
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new TaskInvoker());
		t.start();
		TimeUnit.SECONDS.sleep(3); // Impatiently waiting...
		t.interrupt();
	}
}

class TaskInvoker implements Runnable {
	public void run() {
		try{
			new AHugeTask().doIt();
		} catch(InterruptedException e) {
			System.out.println("Interrupted!");
		}
	}
}
