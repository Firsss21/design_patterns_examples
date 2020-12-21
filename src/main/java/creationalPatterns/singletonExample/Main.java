package creationalPatterns.singletonExample;

public class Main {
    public static void main(String[] args) {
        // неизменяемые синглтоны
        Singleton.INSTANCE.printSomething();
        LazySingleton newLazySingleton = LazySingleton.getInstance();
        SynchronizedSingleton synchronizedSingleton = SynchronizedSingleton.getInstance();
    }
}
