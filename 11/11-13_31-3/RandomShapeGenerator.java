import java.util.*;

public class RandomShapeGenerator implements Iterable{
  private Random rand = new Random(47);
  private Shape[] s;
  public RandomShapeGenerator(int num){
  	s = new Shape[num];
  	for(int i = 0; i < num; i++) {
		switch(rand.nextInt(3)) {
		  default:
		  case 0: s[i] = new Circle();
		  case 1: s[i] = new Square();
		  case 2: s[i] = new Triangle();
		}
  	}
  }

 
  @Override
  public Iterator<Shape> iterator() {
  	return new Iterator<Shape>() {
	  	private Integer index = 0;
  		public Shape next() {
			return s[index++];
  		}
  		public boolean hasNext() {
			return index < s.length;
  		}
  	};
  }
} 
