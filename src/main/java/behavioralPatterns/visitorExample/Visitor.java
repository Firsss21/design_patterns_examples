package behavioralPatterns.visitorExample;

import behavioralPatterns.mementoExample.shapes.*;

public interface Visitor {

    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);

    String export(Shape... shapes);
}
