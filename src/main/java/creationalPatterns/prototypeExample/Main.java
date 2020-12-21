package creationalPatterns.prototypeExample;

import creationalPatterns.prototypeExample.shapes.Circle;
import creationalPatterns.prototypeExample.shapes.Rectangle;
import creationalPatterns.prototypeExample.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // Прототип — это порождающий паттерн проектирования,
    // который позволяет копировать объекты, не вдаваясь в подробности их реализации.
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 5;
        circle.y = 10;
        circle.radius = 3;
        circle.color = "green";
        shapes.add(circle);

        Circle circleCopy = (Circle) circle.clone();
        shapes.add(circleCopy);

        Rectangle rectangle = new Rectangle();
        rectangle.x = 10;
        rectangle.y = 15;
        rectangle.height = 5;
        rectangle.width = 3;
        rectangle.color = "gray";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }

    public static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes)
            shapesCopy.add(shape.clone());

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i))
            {
                System.out.println(i + " element and his copy are different objects");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println("They are identical");
                }
                else {
                    System.out.println("They are not identical");
                }
            }
            else {
                System.out.println(i + " element and his copy are not different objects");
            }
        }
    }
}
