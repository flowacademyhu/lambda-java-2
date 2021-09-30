package hu.flowacademy.lambda.testing;

public class MyOptional<T> {

    private T value;

    private MyOptional(T value) {
        this.value = value;
    }

    public static <T> MyOptional<T> empty() {
        return new MyOptional<>(null);
    }

    public static <T> MyOptional<T> of(T value) {
        return new MyOptional<T>(value);
    }

    public boolean isPresent() {
        return value != null;
    }

    public T getOrDefault(T defaultValue) {
        return value == null ? defaultValue : value;
    }
}
