package ourck.mainconsole;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainConsole{
	public static void main(String[] args) {
		Fiber f = new Fiber(7);
		for(int i = 0; i < 10; i++) {
			System.out.print(f.next() + " ");
		}
		System.out.println();
		System.out.println("----------------------------");
		
		ExecutorService ects = Executors.newCachedThreadPool();
		ExecutorService ects2 = Executors.newFixedThreadPool(5);
		ExecutorService ects3 = Executors.newSingleThreadExecutor();
		
		for(int i = 0; i < 10; i++)
			ects.execute(new Fiber(7));
		for(int i = 0; i < 10; i++)
			ects2.execute(new Fiber(7));
		for(int i = 0; i < 10; i++)
			ects3.execute(new Fiber(7));

		ects.shutdown();
		ects2.shutdown();
		ects3.shutdown();
	}
}
