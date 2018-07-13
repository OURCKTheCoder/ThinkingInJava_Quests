package ourck.mainconsole;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.*;

public class MainConsole{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Fiber f = new Fiber(7);
		for(int i = 0; i < 10; i++) {
			System.out.print(f.next() + " ");
		}
		System.out.println();
		System.out.println("----------------------------");
		
		ExecutorService ects = Executors.newCachedThreadPool();
		List<Future<Integer>> list = new ArrayList<>();
		Fiber f2 = new Fiber(7);
		for(int i = 0; i < 8; i ++)
			list.add(ects.submit(f2));
		for(Future<Integer> i : list)
			System.out.print(i.get() + " ");
		
		ects.shutdown();	
	}
}
