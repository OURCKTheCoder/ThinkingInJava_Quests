
//: typeinfo/Shapes.java
import java.util.*;

abstract class Shape {
  void draw() { System.out.println(this + ".draw()"); }
  static void rotate(Shape s) {
  	if(!(s instanceof Circle)){
  		System.out.println(s + ".rotate()");
  	}
  }
  abstract public String toString();
}

class Circle extends Shape {
  public String toString() { return "Circle"; }
}

class Square extends Shape {
  public String toString() { return "Square"; }
}

class Triangle extends Shape {
  public String toString() { return "Triangle"; }
}

class Rhomboid extends Shape {
  public String toString() { return "Rhomboid"; }
}

public class Shapes {
  public static void main(String[] args) {
    List<Shape> shapeList = Arrays.asList(
      new Circle(), new Square(), new Triangle(), new Rhomboid()
    );
    for(Shape shape : shapeList){
      shape.draw();
      Shape.rotate(shape);
    }

    System.out.println(" - 4-2 & 4-1:");
    Shape r = new Rhomboid();
    ((Rhomboid)r).draw();
    if(r instanceof Circle)
    ((Circle)r).draw();
  }
} /* Output:
Circle.draw()
Square.draw()
Triangle.draw()
*///:~

