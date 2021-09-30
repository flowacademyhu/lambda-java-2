package hu.flowacademy.lambda.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

    @Test
    void testGetByIndex(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        String second = list.get(1);

        assertEquals("b", second);
    }

    @Test
    void testAdd(){
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        assertArrayEquals(new String[]{"a", "b", "c"}, list.toArray());
    }

    @Test
    void testSize(){
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals(3, list.size());
    }

    @Test
    void testRemove(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.remove(1);

        assertArrayEquals(new String[]{"a", "c"}, list.toArray());
    }

    @Test
    void testAddAll(){
        List<String> list = new ArrayList<>();

        list.addAll(Arrays.asList("a", "b", "c"));
        list.addAll(Arrays.asList("d", "e"));

        assertIterableEquals(Arrays.asList("a", "b", "c", "d", "e"), list);
    }
}
