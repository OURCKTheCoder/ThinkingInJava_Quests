import java.lang.reflect.Field;

public class RecursiveTraverse {
	public void printSuper(Class cls) {
		System.out.println(cls.toString());
		for(Field f : cls.getDeclaredFields())
			System.out.println(f);
		if(cls.getSuperclass() != null) {
			printSuper(cls.getSuperclass());
		}
	}

	public static void main(String[] args) {
		RecursiveTraverse r = new RecursiveTraverse();
		r.printSuper(D.class);
	}
}

class A{}
class B extends A{ Integer i = 7;}
class C extends B{}
class D extends C{}
