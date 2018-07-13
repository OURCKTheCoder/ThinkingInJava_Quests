import java.util.concurrent.*;
import java.util.*;

public class RandomSleepTime implements Callable<Integer> {
	private Integer sleepSecond;
	public RandomSleepTime(int sec) { sleepSecond = sec; }
	public Integer call() throws InterruptedException {
		TimeUnit.SECONDS.sleep(sleepSecond);
		System.out.println("Sleeped for " + sleepSecond + " secs.");
		return sleepSecond;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Random rand = new Random(47);
		ExecutorService ects = Executors.newCachedThreadPool();
		for(int i = 0; i < 10; i++)
			ects.submit(new RandomSleepTime(rand.nextInt(10)));
		ects.shutdown();
	}
}
