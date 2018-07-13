package ourck.mainconsole;

import generics.coffee.*;
import java.util.*;

public class CheckedList {
  @SuppressWarnings("unchecked")
  static void oldStyleMethod(List probablyBreve) {
	  probablyBreve.add(new Latte());
  }	
  public static void main(String[] args) {
    List<Breve> breve1 = new ArrayList<Breve>();
    oldStyleMethod(breve1); // Quietly accepts a Cat
    List<Breve> breve2 = Collections.checkedList(
      new ArrayList<Breve>(), Breve.class);
    try {
      oldStyleMethod(breve2); // Throws an exception
    } catch(Exception e) {
      System.out.println(e);
    }
    // Derived types work fine:
    List<Coffee> pets = Collections.checkedList(
      new ArrayList<Coffee>(), Coffee.class);
    pets.add(new Breve());
    pets.add(new Latte()); // OURCK:Class name repeated.
  }
}
