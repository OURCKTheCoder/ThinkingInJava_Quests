//: generics/FactoryConstraint.java

interface FactoryI<T> {
  T create(Integer i);
}

class Foo2<T> {
  private T x;
  public <F extends FactoryI<T>> Foo2(F factory) {
    x = factory.create(666);
  }
  // ...
}

class IntegerFactory implements FactoryI<Integer> {
  public Integer create(Integer i) {
    return new Integer(i);
  }
}	

class Widget {
  public Widget(Integer i) {}
  public static class Factory implements FactoryI<Widget> {
    public Widget create(Integer i) {
      return new Widget(i);
    }
  }
}

public class FactoryConstraint {
  public static void main(String[] args) {
    new Foo2<Integer>(new IntegerFactory());
    new Foo2<Widget>(new Widget.Factory());
  }
} ///:~
