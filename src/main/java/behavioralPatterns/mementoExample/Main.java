package behavioralPatterns.mementoExample;

import behavioralPatterns.mementoExample.shapes.*;
import behavioralPatterns.mementoExample.shapes.CompoundShape;
import behavioralPatterns.mementoExample.shapes.Dot;
import behavioralPatterns.mementoExample.shapes.Rectangle;

import java.awt.*;

public class Main {

    // Снимок — это поведенческий паттерн проектирования,
    // который позволяет сохранять и восстанавливать прошлые состояния объектов,
    // не раскрывая подробностей их реализации.

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),

                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}
