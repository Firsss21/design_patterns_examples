package structuralPatterns.flyweightExample;

import java.awt.*;

public class Main {

    static long CANVAS_SIZE = 1200;
    static long TREES_TO_DRAW = 100000000;
    static long TREE_TYPES = 2;

    // Весь смысл использования Легковеса — в экономии памяти.
    // Поэтому, если в приложении нет такой проблемы, то вы вряд ли найдёте там примеры Легковеса.
    public static void main(String[] args) {
        Forest forest = new Forest();
        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
            forest.plantTree((int)random(0, CANVAS_SIZE),(int) random(0, CANVAS_SIZE),
                    "Tree1", Color.GRAY, "Bereza");
            forest.plantTree( (int)random(0, CANVAS_SIZE), (int) random(0, CANVAS_SIZE),
                    "Tree2", new Color(78, 52, 18), "Topol");
        }
        forest.setSize((int) CANVAS_SIZE,(int) CANVAS_SIZE);
        forest.setVisible(true);
        print();

    }

    private static long random(long min, long max) {
        return min + (long) (Math.random() * ((max - min) + 1));
    }

    private static void print() {
        System.out.println(TREES_TO_DRAW + " trees drawn");
        System.out.println("Tree types size: " + TreeFactory.treeTypes.size());
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);
        System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");
        System.out.println("---------------------");
        System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
    }
}
