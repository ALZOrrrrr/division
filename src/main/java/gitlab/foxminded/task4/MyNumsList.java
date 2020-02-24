package gitlab.foxminded.task4;

import java.util.ArrayList;
import java.util.List;

public class MyNumsList {

    private final List<Integer> myList = new ArrayList<>();

    public void add(int num) {
        myList.add(num);
    }

    public int get(int index) {
        return myList.get(index);
    }

    public int size() {
        return myList.size();
    }

}
