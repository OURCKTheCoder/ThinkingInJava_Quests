
public class MainConsole {
	
	public static void main(String[] args) {
		Obj[] objAry = { new Obj(1), new Obj(2), new Obj(3), new Obj(4) };
		Obj[] ary2 = new Obj[4];
		for(Obj o : ary2) System.out.println(o);
		System.arraycopy(objAry, 0, ary2, 0, objAry.length);
		for(Obj o : ary2) System.out.println(o);
		
		System.out.println(ary2[0].get());
		objAry[0].set(6660);
		System.out.println(ary2[0].get());
	}
	
}

class Obj {
	private int i;
	Obj(int i) {this.i = i;}
	public void set(int val) { i = val; }
	public int get() { return i; }
}

