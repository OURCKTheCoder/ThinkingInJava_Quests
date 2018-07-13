package ourck.mainconsole;

import java.lang.reflect.*;

public class MainConsole {
	public Integer integer = 9;
	
	public static void main (String[] args) throws Exception {
		try {
			Class<?> cls = Class.forName(args[0]);
			Method[] ms = cls.getMethods();
			Constructor[] cs = cls.getConstructors();
			Field[] fs = cls.getFields();
			
			for(Field f : fs) System.out.println(f);
			System.out.println();
			for(Method m : ms) System.out.println(m);
			System.out.println();
			for(Constructor c : cs) System.out.println(c);
			
			System.out.println(ms[5].invoke(cls.newInstance()));//call toString().
			
		} catch(ClassNotFoundException e) {
			System.out.println("Ex!!!!!!!!!!!!!!!!!");
			throw new RuntimeException(e);
		}
	}
}
		

