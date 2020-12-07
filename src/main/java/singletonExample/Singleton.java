package singletonExample;

public class Singleton {
    // Любой класс, которого нужен только один экземпляр можно сделать одиночкой.

    // самая простая реализация.
    private Singleton(){
        System.out.println("singleton with private constructor and only one form created");
    }
    public static final Singleton INSTANCE = new Singleton();

    public void printSomething() {
        System.out.println("print something");
    }
}
