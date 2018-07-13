public class MainConsole {
	public static void main(String[] args) {
		TestExcption t = new TestExcption();
		t.test();
	}
}

class TestExcption {
	public void test(){
		try{
			Integer i = null;
			System.out.println(i.intValue());
		} catch(Exception e) {
			e.printStackTrace();
//			e.printStackTrace(System.out);
		} finally {
			System.out.println("Here!");
		}
	}
}
