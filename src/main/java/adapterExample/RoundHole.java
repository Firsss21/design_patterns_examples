package adapterExample;

public class RoundHole {
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fist(RoundPeg peg) {
        return (this.getRadius() >= peg.getRadius());
    }
}
