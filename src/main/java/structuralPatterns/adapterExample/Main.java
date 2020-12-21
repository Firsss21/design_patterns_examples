package structuralPatterns.adapterExample;

public class Main {
    // Адаптер — это структурный паттерн проектирования,
    // который позволяет объектам с несовместимыми интерфейсами работать вместе.
    public static void main(String[] args) {
        RoundPeg roundPeg = new RoundPeg(5);
        RoundHole roundHole = new RoundHole(3.5);

        if (roundHole.fist(roundPeg)) {
            System.out.println("RoundPeg with r = " + roundPeg.getRadius() +  " fits roundhole with r = " + roundHole.getRadius());
        } else {
            System.out.println("RoundPeg with r = " + roundPeg.getRadius() +  " does'nt fits roundhole with r = " + roundHole.getRadius());
        }

        SquarePeg smallSquarePeg = new SquarePeg(2);
        SquarePeg bigSquarePeg = new SquarePeg(5);

        SquarePegAdapter smallSquarePegAdapter = new SquarePegAdapter(smallSquarePeg);
        SquarePegAdapter bigSquarePegAdapter = new SquarePegAdapter(bigSquarePeg);

        if (roundHole.fist(smallSquarePegAdapter)) {
            System.out.println("SquarePeg with width = " + smallSquarePeg.getWidth() +  " fits roundhole with r = " + roundHole.getRadius());
        } else {
            System.out.println("SquarePeg with width = " + smallSquarePeg.getWidth() +  " does'nt fits roundhole with r = " + roundHole.getRadius());
        }

        if (roundHole.fist(bigSquarePegAdapter)) {
            System.out.println("SquarePeg with width = " + bigSquarePeg.getWidth() +  " fits roundhole with r = " + roundHole.getRadius());
        } else {
            System.out.println("SquarePeg with width = " + bigSquarePeg.getWidth() +  " does'nt fits roundhole with r = " + roundHole.getRadius());
        }
    }
}
