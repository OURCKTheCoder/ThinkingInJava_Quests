class Rodent{

	public void eat(){
		System.out.println("Rodent.eat()");
	}
	
}

class Mouse extends Rodent{

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

public class RodentWithInheriting{

	public static void main(String[] args){
		Rodent[] mice = {
			new Rodent(),
			new Mouse(),
			new Gerbil(),
			new Hamster()
		};
		
		for(Rodent mouse : mice){
			mouse.eat();
		}
	}
}


