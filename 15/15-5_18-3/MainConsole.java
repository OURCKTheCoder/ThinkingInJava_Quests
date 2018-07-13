package ourck.mainconsole;

import net.mindview.util.Generator;

public class MainConsole {
	
	public static void main (String[] args) {
		for(int i = 0; i < 10; i++) {
			System.out.println(BigFish.generator.next() + 
					" eats " + SmallFish.generator.next());
		}
	}
}

class BigFish {
	private static int count = 0;
	private int id = ++count;
	private BigFish() {}
	public String toString() { return "BigFish" + id; }
	public static Generator<BigFish> generator = new Generator<BigFish>() {
		public BigFish next() {
			return new BigFish();
		}
	};
}

class SmallFish{
	private static int count = 0;
	private int id = ++count;
	private SmallFish() {}
	public String toString() { return "SmallFishl" + id; }
	public static Generator<SmallFish> generator = new Generator<SmallFish>() {
		public SmallFish next() {
			return new SmallFish();
		}
	};
}

