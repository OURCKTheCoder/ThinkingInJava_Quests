interface Rodent{
	
	public void eat();
		
}

class Mouse implements Rodent{

	public void eat(){
		System.out.println("Mouse.eat()");
	}
	
}

class Gerbil extends Mouse{

	public void eat(){
		System.out.println("Gerbil.eat()");
	}
	
}

class Hamster extends Gerbil{
	
	public void eat(){
		System.out.println("Hamster.eat()");
	}
	
}

public class RodentWithInterface{

	public static void main(String[] args){
		Rodent[] mice = {
			new Mouse(),
			new Gerbil(),
			new Hamster()
		};
		
		for(Rodent mouse : mice){
			mouse.eat();
		}
	}
}


