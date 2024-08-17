import java.util.LinkedList;

// Class representing a single entry in the hash table
class HashTableEntry {
    int key;
    String value;

    HashTableEntry(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

// Class representing the hash table
public class HashTable {
    private static final int SIZE = 10; // Size of the hash table
    private LinkedList<HashTableEntry>[] table;

    // Constructor to initialize the hash table
    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function to compute the index for a given key
    private int hash(int key) {
        return key % SIZE;
    }

    // Method to insert a key-value pair into the hash table
    public void put(int key, String value) {
        int index = hash(key);
        LinkedList<HashTableEntry> bucket = table[index];

        // Check if the key already exists and update the value if it does
        for (HashTableEntry entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        // If the key does not exist, add a new entry
        bucket.add(new HashTableEntry(key, value));
    }

    // Method to get the value associated with a given key
    public String get(int key) {
        int index = hash(key);
        LinkedList<HashTableEntry> bucket = table[index];

        // Search for the key in the bucket
        for (HashTableEntry entry : bucket) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        // Return null if the key is not found
        return null;
    }

    // Method to remove a key-value pair from the hash table
    public void remove(int key) {
        int index = hash(key);
        LinkedList<HashTableEntry> bucket = table[index];

        // Iterate through the bucket and remove the entry if found
        for (HashTableEntry entry : bucket) {
            if (entry.key == key) {
                bucket.remove(entry);
                return;
            }
        }
    }

    // Method to check if a key exists in the hash table
    public boolean containsKey(int key) {
        return get(key) != null;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        // Insert key-value pairs
        hashTable.put(1, "Value1");
        hashTable.put(2, "Value2");
        hashTable.put(11, "Value11"); // This will hash to the same bucket as key 1

        // Retrieve and print values
        System.out.println("Value for key 1: " + hashTable.get(1)); // Output: Value1
        System.out.println("Value for key 2: " + hashTable.get(2)); // Output: Value2
        System.out.println("Value for key 11: " + hashTable.get(11)); // Output: Value11

        // Remove a key-value pair and print the result
        hashTable.remove(1);
        System.out.println("Value for key 1 after removal: " + hashTable.get(1)); // Output: null
    }
}
