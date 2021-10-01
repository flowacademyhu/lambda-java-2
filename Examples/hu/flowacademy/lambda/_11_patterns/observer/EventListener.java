package hu.flowacademy.lambda._11_patterns.observer;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}
