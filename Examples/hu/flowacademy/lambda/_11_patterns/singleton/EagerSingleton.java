package hu.flowacademy.lambda._11_patterns.singleton;

public class EagerSingleton {

    private static volatile EagerSingleton instance = new EagerSingleton();

    // private constructor
    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}