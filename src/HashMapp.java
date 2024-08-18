import java.util.HashMap;
import java.util.Map;

public class HashMapp{
    public static void main(String[] args){
        Map<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "Hello");
        hashMap.put(2, "Goodbye");
        hashMap.put(3, "Hi");

        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(3));

        System.out.println("Contains key 3: " + hashMap.containsKey(3));

        hashMap.remove(2);

        System.out.println("Contains key 2: " + hashMap.containsKey(2));

        for (Map.Entry<Integer, String> entry : hashMap.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}