import java.util.*;
public class GerbilMap{
	public static void main(String[] args){
		Map<String, Gerbil> gb = new HashMap<String, Gerbil>();
		gb.put("Tom", new Gerbil(1));
		gb.put("Jerry", new Gerbil(2));
		gb.put("TheFatRat", new Gerbil(3));
		gb.put("Mary", new Gerbil(4));
		gb.put("John", new Gerbil(5));
		
		Iterator<String> keyIt = gb.keySet().iterator();
		
		while(keyIt.hasNext()){
			Gerbil g = gb.get(keyIt.next());
			g.hop();
		}
	}
}

