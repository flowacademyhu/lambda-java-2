package hu.flowacademy.lambda._11_patterns.strategy;

import java.util.LinkedList;
import java.util.List;

public class InsertionSortStrategy implements SortStrategy {

    public List<Integer> sort(List<Integer> list) {
        if (list == null || list.size() < 2){
            return list;
        }

        LinkedList<Integer> linkedList = new LinkedList<Integer>(list);

        for (int index = 1; index < linkedList.size(); index++){
            insert(linkedList,index);
        }
        return linkedList;
    }

    private void insert(List<Integer> list, int sorted) {
        for (int index = 0; index<sorted; index++){
            if (list.get(sorted) < list.get(index)){
                list.add(index, list.remove(sorted));
                return;
            }
        }
    }

}