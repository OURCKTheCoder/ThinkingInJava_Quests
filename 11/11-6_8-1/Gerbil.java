import java.util.*;

public class Gerbil{
	private int gerbilNum;
	public Gerbil(int val) { gerbilNum = val; }
	public void hop() { System.out.println( gerbilNum + " : I'm hopping!"); }
	
	public static void main(String[] args){
		ArrayList<Gerbil> gbs = new ArrayList<Gerbil>();
		Collections.addAll(gbs, new Gerbil(1),
								new Gerbil(2),
								new Gerbil(3),
								new Gerbil(4)
							);
		
//		for(Gerbil gb : gbs) gb.hop();
		Iterator<Gerbil> it = gbs.iterator();
		while(true){
			if(it.hasNext()){
				it.next().hop();	
			}
			else{
				break;
			}
		}
	}
}
