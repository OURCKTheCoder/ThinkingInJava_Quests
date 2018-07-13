//: generics/ClassTypeCapture.java

import java.util.HashMap;

class Building {}
class House extends Building {}

public class ClassTypeCapture<T> {
  Class<T> kind;
  
  private HashMap<String, Class<?>> m = new HashMap<>();
  public void addType(String typename, Class<?> kind) {
	  m.put(typename, kind);
  }
  public Object createNew(String typename) {
	  try {
		return Class.forName(typename).newInstance();
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
  }
  
  public ClassTypeCapture(Class<T> kind) {
    this.kind = kind;
  }
  public boolean f(Object arg) {
    return kind.isInstance(arg);
  }	
  public static void main(String[] args) {
    ClassTypeCapture<Building> ctt1 =
      new ClassTypeCapture<Building>(Building.class);
    System.out.println(ctt1.f(new Building()));
    System.out.println(ctt1.f(new House()));
    ClassTypeCapture<House> ctt2 =
      new ClassTypeCapture<House>(House.class);
    System.out.println(ctt2.f(new Building()));
    System.out.println(ctt2.f(new House()));
    
    ctt1.addType("Building1", Building.class);
    ctt1.addType("House1", House.class);
    System.out.println(ctt1.createNew(House.class.getCanonicalName()));
  }
} /* Output:
true
true
false
true
*///:~
