package behavioralPatterns.visitorExample;

import behavioralPatterns.mementoExample.shapes.Circle;
import behavioralPatterns.mementoExample.shapes.CompoundShape;
import behavioralPatterns.mementoExample.shapes.Dot;
import behavioralPatterns.mementoExample.shapes.Rectangle;
import behavioralPatterns.mementoExample.shapes.Shape;

import java.awt.*;

public class Main {

    // Посетитель — это поведенческий паттерн проектирования,
    // который позволяет добавлять в программу новые операции,
    // не изменяя классы объектов, над которыми эти операции могут выполняться.

    public static void main(String[] args) {
       CompoundShape compoundShape = new CompoundShape(
                new Circle(110, 110, 50, Color.RED),
                new Dot(160, 160, Color.RED)
        );

       CompoundShape compoundShape1 = new CompoundShape(
                new Rectangle(250, 250, 100, 100, Color.GREEN),
                new Dot(240, 240, Color.GREEN),
                new Dot(240, 360, Color.BLUE),
                new Dot(360, 360, Color.GREEN),
                new Dot(360, 240, Color.YELLOW)
        );

       export(compoundShape, compoundShape1);
    }

    private static void export(Shape... shapes) {
        Visitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }
}
