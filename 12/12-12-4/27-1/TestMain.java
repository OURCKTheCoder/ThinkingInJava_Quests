public class TestMain {
	public void testThrowing() throws ArrayIndexOutOfBoundsException {
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public static void main(String[] args) {
		try{
			TestMain t = new TestMain();
			t.testThrowing();
		} catch(ArrayIndexOutOfBoundsException e) {
			RuntimeException re = new RuntimeException(e); // Don't have to "throws RTEXP" in main	
//			re.getCause();
			throw re;
		}
	}
}
