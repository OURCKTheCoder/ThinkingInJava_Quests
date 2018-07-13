/*-------------------------------------
 *	OURCK - ThreadLocal:根除变量的共享
 *-------------------------------------

/* 
 * 这一点上，跟Java的内部类传参机制有点像
 * （都是拷贝式而非直接能使用引用）
 */

import java.util.concurrent.*;
import java.util.*;

public class MainConsole {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 10; i++) {
			exec.execute(new MyThread());
		}
		exec.shutdown();
	}
}

class ThreadLocalVar {
	private static ThreadLocal<Integer> var = 
		new ThreadLocal<Integer>() { 
		// ThreadLocal对象将会在每个独立线程中各自单独持有一个
			protected synchronized Integer initialValue() {
				Random rand = new Random(System.nanoTime());
				return rand.nextInt(1000);
			}
		};
	public static void increment() { var.set(var.get() + 1); }
	public static int get() { return var.get(); }
}

class MyThread extends Thread {
	public void run() {
		for(int i = 0; i < 10; i++) {
			ThreadLocalVar.increment();
			System.out.println(this + " " + ThreadLocalVar.get());
		}
	}
}
