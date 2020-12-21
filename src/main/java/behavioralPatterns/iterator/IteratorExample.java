package behavioralPatterns.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorExample {

    static class Main {
        public static void main(String[] args) {
            PersonalComputer PC = new PersonalComputer();

            PC.setCpu(new PersonalComputer.Cpu());
            PC.setMotherboard(new PersonalComputer.Motherboard());
            PC.setGraphicCard(new PersonalComputer.GraphicCard());

            Iterator iterator = new PcIterator(PC);
            System.out.println("While pc has next part");
            while (iterator.hasNext()) {
                System.out.println("behavioralPatterns.iterator.next " + iterator.next());
                System.out.println("behavioralPatterns.iterator remove ");
                iterator.remove();
            }

        }

    }

    static class PcIterator implements Iterator<IteratorExample.Part>{
        private int index = -1;
        private PersonalComputer pc;

        public PcIterator(PersonalComputer pc) {
            this.pc = pc;
        }

        public boolean hasNext() {
            if (index == -1) return pc.hasMotherboard() || pc.hasGraphicCard() || pc.hasCpu();
            if (index == 0) return pc.hasGraphicCard() || pc.hasCpu();
            if (index == 1) return pc.hasCpu();
            return false;
        }

        public Part next() {
            if (index == -1) {
                if (pc.hasMotherboard()) { index = 0; return pc.getMotherboard(); }
                if (pc.hasGraphicCard()) { index = 1; return pc.getGraphicCard(); }
                if (pc.hasCpu()) { index = 2; return pc.getCpu(); }
            }
            if (index == 0) {
                if (pc.hasGraphicCard()) { index = 1; return pc.getGraphicCard(); }
                if (pc.hasCpu()) { index = 2; return pc.getCpu(); }
            }
            if (index == 1) {
                if (pc.hasCpu()) { index = 2; return pc.getCpu(); }
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (index == -1) throw new IllegalStateException();
            if (index == 0)
                if (pc.hasMotherboard()) pc.setMotherboard(null);
                else throw new IllegalStateException();
            if (index == 1)
                if (pc.hasGraphicCard()) pc.setGraphicCard(null);
                else throw new IllegalStateException();
            if (index == 2)
                if (pc.hasCpu()) pc.setCpu(null);
                else throw new IllegalStateException();
        }
    }

    static class PersonalComputer {
        private Motherboard motherboard;
        private GraphicCard graphicCard;
        private Cpu cpu;




        public Motherboard getMotherboard() {
            return motherboard;
        }

        public void setMotherboard(Motherboard motherboard) {
            this.motherboard = motherboard;
        }

        public boolean hasMotherboard() { return motherboard != null; }

        public GraphicCard getGraphicCard() {
            return graphicCard;
        }

        public void setGraphicCard(GraphicCard graphicCard) {
            this.graphicCard = graphicCard;
        }

        public boolean hasGraphicCard() { return graphicCard != null; }

        public Cpu getCpu() {
            return cpu;
        }

        public void setCpu(Cpu cpu) {
            this.cpu = cpu;
        }

        public boolean hasCpu() { return cpu != null; }


        static class Motherboard implements Part {
        }

        static class GraphicCard implements Part {
        }

        static class Cpu implements Part {
        }


    }
    public interface Part {
    }
}
