package hu.flowacademy.lambda._11_patterns.strategy;

import java.util.Collections;
import java.util.List;

public class BubbleSortStrategy implements SortStrategy {

    public List<Integer> sort(List<Integer> list) {
        if (list == null || list.size() < 2) {
            return list;
        }
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int index = 0; index < list.size() - 1; index++) {
                if (list.get(index) > list.get(index + 1)) {
                    Collections.swap(list, index, index + 1);
                    swapped = true;
                }
            }
        }
        return list;
    }
}
