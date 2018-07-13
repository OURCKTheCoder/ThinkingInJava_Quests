import java.util.*;

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

public class RodentWithList{

	public static void main(String[] args){
		List<Rodent> mice = new ArrayList<Rodent>();
		Collections.addAll(mice,
							new Rodent(),
							new Mouse(),
							new Gerbil(),
							new Hamster()
		);
		
//		for(Rodent mouse : mice){
//			mouse.eat();
//		}
		
		Iterator<Rodent> it = mice.iterator();
		while(true){
			if(it.hasNext()){
				it.next().eat();
			}
			else{
				break;
			}
		}
	}
}


