package hashmap;

import java.util.*;

public class SortHashMap {
    Map<Integer, Integer> map = new HashMap<>();

    List<Map.Entry<Integer, Integer>> list =
            new ArrayList<>(map.entrySet());

//    Collections.sort(list, (a, b) -> b.getValue() - a.getValue());


}
