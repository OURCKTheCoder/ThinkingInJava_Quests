package ourck.mainconsole;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainConsole {

	public static void main(String[] args) {
		ExecutorService ect = Executors.newCachedThreadPool();
		for(int i = 0; i < 10; i++)
			ect.execute(new Poper("Ho!"));

		ExecutorService ect2 = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 20; i++)
			ect2.execute(new Poper("Hey!"));

		ExecutorService ect3 = Executors.newSingleThreadExecutor();
		for(int i = 0; i < 20; i++)
			ect3.execute(new Poper("Yo!"));
		
		ect.shutdown();	
		ect2.shutdown();
		ect3.shutdown();
	}
	
}
