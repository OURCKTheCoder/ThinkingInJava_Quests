package ourck.mainconsole;
public class MainConsole {
	
}

class ExA extends Exception {
	ExA() throws Exception{
		System.out.println("Exa!");
		throw new Exception();
	}
}
class ExB extends ExA {
	ExB() throws Exception{}
//1.'catch' without 'try' not allowed:
//	ExB() { catch{} }
	
//2.Calling of base class's constructor must be the first sentence. 
//	So this is not allowed:
//	ExB() {
//		try {
//			super();
//		} catch(Exception e) {
//			
//		}
//	}
}