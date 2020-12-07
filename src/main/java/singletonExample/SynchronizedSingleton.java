package singletonExample;

public class SynchronizedSingleton {
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {
        System.out.println("better synchronized singleton created");
    }

    public static SynchronizedSingleton getInstance() {
        if (instance == null) { // потоки здесь ждут, пока освободится
            synchronized (SynchronizedSingleton.class) {
                if (instance == null) {
                    instance = new SynchronizedSingleton();
                }
            }
        }
        return instance;
    }
}
