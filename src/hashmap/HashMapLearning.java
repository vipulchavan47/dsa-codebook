package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapLearning {
    public static void main(String[] args) {
        // Creating a HashMap with key type String and value type Integer
        Map<String, Integer> map = new HashMap<>();

        // Adding elements
        map.put("Apple", 50);
        map.put("Banana", 20);
        map.put("Mango", 70);

        // Accessing Elements:
        System.out.println("Price of Apple: " + map.get("Apple"));  // retrieve value
        System.out.println("Contains Banana? " + map.containsKey("Banana")); // check key
        System.out.println("Contains value 70? " + map.containsValue(70));   // check value


        // Updating and removing:
        map.put("Apple", 60); // updates value for Apple
        map.remove("Banana"); // removes Banana
        System.out.println("After update & remove: " + map);

        // Iterating through HashMap

        // (a) Using for-each with entrySet()
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        //(b) Iterating over keys
        for (String key : map.keySet()) {
            System.out.println("Key: " + key);
        }

        //(c) Iterating over values
        for (Integer value : map.values()) {
            System.out.println("Value: " + value);
        }

        //(d) Using Iterator
        Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        //(e) Using forEach method (Java 8+)
        map.forEach((key, value) -> System.out.println(key + " => " + value));


        // --- 5. Size and Clear
        System.out.println("Size: " + map.size());
        map.clear();  // removes all elements
        System.out.println("Empty? " + map.isEmpty());


    }

}
