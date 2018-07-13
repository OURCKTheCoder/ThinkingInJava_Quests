//: net/mindview/util/TwoTuple.java
package net.mindview.util;

public class TwoTuple<A,B> implements Comparable<TwoTuple<A, B>>{
  public final A first;
  public final B second;
  public TwoTuple(A a, B b) { first = a; second = b; }
  public String toString() {
    return "(" + first + ", " + second + ")";
  }
  @Override
  public int hashCode() {
	  int result = 0;
	  result = 37 * result + first.hashCode();
	  result = 37 * result + second.hashCode();
	  return result;
  }
  @Override
  public boolean equals(Object obj) {
	  try {
		  return first == ((TwoTuple)obj).first &&
				  second == ((TwoTuple)obj).second;
	  } catch(ClassCastException e) {
		  e.printStackTrace();
		  return false;
	  }
  }
  
  @Override
  public int compareTo(TwoTuple obj) {
	  String name1 = first.getClass().getSimpleName();
	  String name2 = second.getClass().getSimpleName();
	  
	  int firstround = name1.compareTo(obj.first.getClass().getSimpleName());
	  if(firstround != 0) return firstround;
	  
	  int secondround = name2.compareTo(obj.second.getClass().getSimpleName());
	  return secondround;
	  
	  
  }
} ///:~
