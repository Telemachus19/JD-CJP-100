package Lab05;

import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    public abstract void draw();
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class testShapes {

    public void drawAllShapes(List<? extends Shape> shapeList) {
        for (Shape s : shapeList) {
            s.draw();
        }
    }
}

public class ShapeExercise {

    public static void main(String[] args) {
        testShapes ts = new testShapes();
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Rectangle());
        shapes.add(new Circle());
        ts.drawAllShapes(rectangles);
        ts.drawAllShapes(shapes);
    }
}