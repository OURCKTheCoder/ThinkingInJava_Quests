public class MainConsole {
	public static void main(String[] args) {
		try{
			throw new Exception(){
				//TODO you may add some cool sh*t here.
			};
		} catch(Exception e) {
			e.printStackTrace();
//			e.printStackTrace(System.out);
		} finally {
			System.out.println("Here!");
	
	}
}
		
