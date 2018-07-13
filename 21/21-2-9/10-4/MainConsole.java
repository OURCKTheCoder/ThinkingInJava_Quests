package ourck.mainconsole;

import java.util.concurrent.ExecutionException;

public class MainConsole{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Fiber f = new Fiber(7);
		for(int i = 0; i < 7; i++) {
			System.out.print(f.next() + " ");
		}
		System.out.println();
		System.out.println("----------------------------");

		Fiber f2 = new Fiber(7);
		f2.runAsThread();
	}
}
