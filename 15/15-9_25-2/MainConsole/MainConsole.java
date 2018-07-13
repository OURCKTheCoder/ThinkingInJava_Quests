package MainConsole;
import SampleInterface.*;

public class MainConsole implements SmpItf1, SmpItf2 {
	public <T extends SmpItf1> void genericM1(T obj) {
		obj.show1();
	}
	
	public <T extends SmpItf2> void genericM2(T obj) {
		obj.show2();
	}
	
	public void show1() { System.out.println("SHow1"); }
	
	public void show2() { System.out.println("SHow2"); }

	public static void main(String[] args) {
		MainConsole m = new MainConsole();
		m.genericM1(m);
		m.genericM2(m);
	}
}
