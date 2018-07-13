//: enumerated/cartoons/EnumImplementation.java
// An enum can implement an interface
package enumerated.cartoons;
import java.util.*;

enum CartoonCharacterII{
  SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
  private static Random rand = new Random(47);
  public static CartoonCharacterII next() {
//	  return values()[rand.nextInt(values().length)];
	  CartoonCharacterII[] ary = values();
	  return ary[rand.nextInt(ary.length)];
  }
}

public class EnumImplementation_StaticVer {
  public static void main(String[] args) {
    // Choose any instance:
    for(int i = 0; i < 10; i++)
    	System.out.println(CartoonCharacterII.next());
    }
} /* Output:
BOB, PUNCHY, BOB, SPANKY, NUTTY, PUNCHY, SLAPPY, NUTTY, NUTTY, SLAPPY,
*///:~
