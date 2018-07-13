import java.util.concurrent.*;

/*-------------------------------------
 *	OURCK - 失效的synchronized
 *	2018年5月22日 下午10:01:32
 *-------------------------------------

/* 
 * 执行该代码，观察输出。
 * 为什么加了synchronized还是出现数据不同步的问题？
 * （程序执行对两个数同步减的操作）
 * 
 * 注：
 * 进一步实验发现凡是synchronized方法
 * 和synchronized(this)
 * 都有这一种情况
 * ——特别是在有大量循环的情况下
 * 
 * [#] 2018-5-22：已处理
 * 原因在于这一语句：
 * 
			Thread t = new Thread(new TableManner());
			
 * 每次调用这语句，都会生成一个新的TableManner()。
 * 导致借由此上的锁synchronized(this)里的“this” #不是同一个对象# ！
 * 解决办法很简单，这么改：
 * 
			TableManner task = new TableManner();		// 置于循环之外
			for(int i = 0; i < 10; i++) {
 				Thread t = new Thread(task);			// 所有线程共同驱动一个任务
				exec.execute(t);
		}
 * 
 * 术语”线程“和”任务“是不一样的。由于在线程中编写run()执行了一系列动作，
 * 这就给人一个印象：“线程”即是“任务”
 * 实际上线程（Thread类）只负责驱动任务（TableManner的run()）。
 * 
 * 换句话说：这个程序有问题的原因在于
 * 在for语句块中，生成了10个线程和10个任务，每个任务把共享的肉和酒拿走一份，共10对肉+酒（10X1）。
 * 可问题是，原来的设计中，只有 #一个# 任务，只把共享的肉和酒拿走一份，共一对肉+酒（1X1）。
 */

public class Synchronized_Invalid {
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		TableManner task = new TableManner();
		for(int i = 0; i < 10; i++) {
			Thread t = new Thread(task);
			exec.execute(t);
		}
		System.out.println(" - 不同步是不可能不同步的，这辈子都不可能不同步的。");
		exec.shutdown();
	}
}
//
//class ExpHandler implements Thread.UncaughtExceptionHandler {
//	public void uncaughtException(Thread t, Throwable e) {
//		System.err.println(t + "Throwed a Exception: " + e);
//	}
//}

class TableManner implements Runnable {
	// Always take a piece of meat with a bottle of wine!
	private static int meatNum = 0;
	private static int wineNum = 0;
	private synchronized boolean takeSomething() {
		meatNum--;
		wineNum--;
		if(meatNum != wineNum)
			return false;
		else
			return true;
	}
	
	public void run() {
		while(takeSomething());
		System.out.println(" [ ! ] Meat: " + meatNum + " Wine: " + wineNum);
	}
}
