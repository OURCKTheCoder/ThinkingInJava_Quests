//: reusing/SprinklerSystem.java
// Composition for code reuse.

class WaterSource {
  private String s;
  WaterSource() {
    System.out.println("WaterSource()");
    s = "Constructed";
  }
  public String toString() { return s; }
}	

public class SprinklerSystem {
  private String valve1, valve2, valve3, valve4;
  private WaterSource source = new WaterSource();
  private int i;
  private float f;
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("valve1 = ");
    s.append(valve1);
    s.append(" ");
    s.append("valve2 = ");
    s.append(valve2);
    s.append(" ");
    s.append("valve3 = ");
    s.append(valve3);
    s.append(" ");
    s.append("valve4 = ");
    s.append(valve4);
    s.append(" ");
	 s.append("\n");
	 
	 s.append("i = ");
    s.append(i);
    s.append(" ");
    s.append("f = ");
    s.append(f);
    s.append(" ");

    s.append("source = ");
    s.append(source);

	 return s.toString();
  }	
  public static void main(String[] args) {
    SprinklerSystem sprinklers = new SprinklerSystem();
    System.out.println(sprinklers);
  }
} /* Output:
WaterSource()
valve1 = null valve2 = null valve3 = null valve4 = null
i = 0 f = 0.0 source = Constructed
*///:~
