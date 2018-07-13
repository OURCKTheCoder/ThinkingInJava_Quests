public class WhatsInThePot {
	public static void main(String[] args) {
		SmallPot p = new SmallPot();
		p.process(p);
	}
}

abstract class Pot<T extends Pot<T>> { //1.Self-bouned declaration
	public abstract T put(T something);
	public void process(T something) { put(something); }
}

class SmallPot extends Pot<SmallPot> { //2.Child class uses Self-bouned method.
	public SmallPot put(SmallPot something) {
		System.out.println(something + " was processed by the small pot!");
		return something;
	}
}
