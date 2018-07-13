import java.lang.reflect.*;

public class GetByReflect {
	
	public void violetCall(Class<?> cls, String methodName) {
		try{
			Method m1 = cls.getDeclaredMethod(methodName);
			m1.setAccessible(true);
			m1.invoke(cls.newInstance());
		} catch(NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch(InstantiationException e) {
			throw new RuntimeException(e);
		} catch(IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch(Exception e) {
			System.err.println("Ex!!!!!!!!");
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		GetByReflect g = new GetByReflect();
		try{
			g.violetCall(NotPublic.class, "foo");
			g.violetCall(NotPublic.class, "bar");
			g.violetCall(NotPublic.class, "fun");
			g.violetCall(NotPublic.class, "fooooo?");
		} catch(Exception e) {
			System.out.println(" ...Gulp.");
		}
		System.out.println(" [+] I'm still alive!");
	}
	
}
