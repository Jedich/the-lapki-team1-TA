package labka1;

import java.util.Comparator;

public class MyComp implements Comparator<Integer> {
    public int compare(Integer int1, Integer int2) {
        return int1.compareTo(int2);
    }

}