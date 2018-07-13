
public class TestMain {
	
	Action test() {
		if(true) {
			class Fly implements Action{ // <- Inner class in a method
				public void doIt() { System.out.println("I can fly!"); }
			}			
			return new Fly();
		}
		return null; // <- 实际上不会执行：Dead code.
	}
	
	public static void main(String[] args) {
		TestMain testMain = new TestMain();
		testMain.test().doIt();
	}

}

interface Action{
	void doIt();
}
