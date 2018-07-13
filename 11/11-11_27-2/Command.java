import java.util.*;

public class Command{
	private String str;
	Command(String str){
		this.str = str;
	}
	public void show() { System.out.println(str); }

	public static void main(String[] args){
		CmdQueue cq = new CmdQueue();
		FrontEnd.go(cq.getQ());
	}
}

class CmdQueue{
	private Queue<Command> q;
	CmdQueue(){
		q = new LinkedList<Command>();
		 //LinkedList可以做栈，也可以做队列。
		//说到底，Queue其实实现了LinkedList.
		q.offer(new Command("cd"));
		q.offer(new Command("ls"));
		q.offer(new Command("dir"));
		q.offer(new Command("nmblookup"));
		q.offer(new Command("lspci"));
		q.offer(new Command("ifconfig"));
	}
	public Queue<Command> getQ() { return q; }
}		

class FrontEnd{
	public static void go(Queue<Command> q){
		while(q.peek() != null){
			q.poll().show();
		}
	}
}
