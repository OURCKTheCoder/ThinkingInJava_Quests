import java.util.*;

public class Doge{
	private int index;
	Doge(int val){ index = val; }
	public String toString() { return "doge" + index; }

	public static void main(String[] args){
		List<Doge> dogs = new ArrayList<Doge>();
		Collections.addAll(dogs,
							new Doge(1),
							new Doge(2),
							new Doge(3),
							new Doge(4),
							new Doge(5)
		);
		
		System.out.println(dogs);
		
		List<Doge> somedogs = dogs.subList(2,4);
		dogs.removeAll(somedogs);
		
		System.out.println(dogs);
	}
}

