package singletonExample;
// ленивая реализация синглтона, для создания объекта по вызову специального метода.

public class LazySingleton {

//    volatile модификатор делает так,
//    что каждый поток не создает свою копию переменной,
//    а все потоки работают с одной и той же.
//    private static volatile LazySingleton instance;

    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("lazySingleton Created");
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) instance = new LazySingleton();
        return instance;
    }
}
