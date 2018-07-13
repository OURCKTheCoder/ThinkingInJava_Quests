import java.util.*;

public class Gerbil{
	private int gerbilNum;
	public Gerbil(int val) { gerbilNum = val; }
	public void hop() { System.out.println( gerbilNum + " : I'm hopping!"); }
	
	public static void main(String[] args){
		ArrayList<Gerbil> gbs = new ArrayList<Gerbil>();
		gbs.add(new Gerbil(1));
		gbs.add(new Gerbil(1));
		gbs.add(new Gerbil(1));

		for(Gerbil gb : gbs) gb.hop();
	}
}
