package hu.flowacademy.lambda.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyOptionalTest {

    @Test
    void createEmpty() {
        MyOptional<String> emptyOptional = MyOptional.empty();
        assertFalse(emptyOptional.isPresent());
    }

    @Test
    void createOfValue() {
        String value = "kacsa";
        MyOptional<String> fullOptional = MyOptional.of(value);
        assertTrue(fullOptional.isPresent());
    }

    @Test
    void getOrDefault() {
        String defaultValue = "kacsa";
        MyOptional<String> emptyOptional = MyOptional.empty();
        String result = emptyOptional.getOrDefault(defaultValue);
        assertEquals(defaultValue, result );
    }
}
