public class FailingConstructor {
	NeedToBeCleaned n1;
	FailingConstructor() throws Exception {
		n1 = new NeedToBeCleaned();
		throw new Exception();
	}
	
	public void dispose(){
		System.out.println("Disposing...'");
	}
	
	public static void main(String[] args) {
		try{
			FailingConstructor f = new FailingConstructor();
			try{
				FailingConstructor f1 = new FailingConstructor();
			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("I'm still alive!");
	}
}

class NeedToBeCleaned {}
