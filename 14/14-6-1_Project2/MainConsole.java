import java.lang.reflect.*;

public class MainConsole {
	public static void main (String[] args) throws Exception {
		FruitKnife fk = new FruitKnife();
		Knife k = (Knife)Proxy.newProxyInstance(FruitKnife.class.getClassLoader(),
								new Class[] { Knife.class },
								new KnifeProxy(fk));
//		fk.cut(9);
		k.cut(10);
		System.out.println();
		k.cut(5);
	}
}

interface Knife {
	void cut(Integer withPower) throws Exception;
}

class FruitKnife implements Knife {
	public void cut(Integer withPower) throws Exception { // Imagine when you're cutting a watermelon.
		if(withPower < 7) {
			System.out.println("[!] No enough strength.");
			throw new Exception("U are too weak ^_^");
		}
		else {
			System.out.println("[!] OK!");
		}
	}
}

class KnifeProxy implements InvocationHandler {
	private Object proxied;
	public KnifeProxy(Object proxied) {
		this.proxied = proxied;
	}
	public Object invoke(Object obj, Method methodName, Object[] args) {
		System.out.println(methodName.getName() + " was called with args" + args);
		try {
			return methodName.invoke(proxied, args);
			//May cause InvocationTargetException, but it doesn't matter.
		} catch(Exception e) {
			System.err.println("[!] Ex!!!!!!! Rolling back now.");
			throw new RuntimeException(e);
		}
	}
}

