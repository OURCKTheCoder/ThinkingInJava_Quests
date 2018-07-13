public class MainConsole {

	public static void main(String[] args) {
		Gerbil g = new Gerbil();
		g.eat();
	}

}

abstract class Rodent{
	
	abstract public void eat();
}

abstract class Mouse extends Rodent{
	Mouse(){
		eat();
	}
	abstract public void eat();
}

class Gerbil extends Mouse{
	private Integer i = new Integer(7);
	public void eat() {
		System.out.println("Gerbil.eat()" + i);
		
	}
}

class Hamster extends Mouse{
	public void eat() {
		System.out.println("Hamster.eat()");
	}	
}
