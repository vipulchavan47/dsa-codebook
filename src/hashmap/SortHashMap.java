package hashmap;

import java.util.*;

public class SortHashMap {
    Map<Integer, Integer> map = new HashMap<>();

    // Convert it to list
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

    // Sort the list (here we are sorting by values (K,V) )
//    Collections.sort(list, (a, b) -> Integer.compare(b.getValue(), a.getValue());


}
