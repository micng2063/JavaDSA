import java.util.HashMap;
import java.util.Map;

public class HashMapEx {
    public static void main(String[] args) {
        // Create a HashMap
        Map<Integer, String> hashMap = new HashMap<>();

        // Insert key-value pairs
        hashMap.put(1, "Value1");
        hashMap.put(2, "Value2");
        hashMap.put(3, "Value3");

        // Retrieve values
        System.out.println("Value for key 1: " + hashMap.get(1)); // Output: Value1
        System.out.println("Value for key 2: " + hashMap.get(2)); // Output: Value2

        // Check if a key exists
        System.out.println("Contains key 3: " + hashMap.containsKey(3)); // Output: true

        // Remove a key-value pair
        hashMap.remove(2);

        // Print all key-value pairs
        System.out.println("HashMap contents:");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
