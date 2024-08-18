import java.util.LinkedList;

public class HashTable {
    static class Entry{
        int key;
        String value;

        Entry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 10;

    private LinkedList<Entry>[] table;

    public HashTable(){
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++){
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key){
        return key % SIZE;
    }

    public void put(int key, String value){
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];

        for (Entry entry : bucket){
            if (entry.key == key){
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry(key, value));
    }

    public String get(int key){
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];

        for (Entry entry : bucket){
            if (entry.key == key){
                return entry.value;
            }
        }

        return null;
    }

    public void remove(int key){
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];

        for (Entry entry : bucket){
            if (entry.key == key){
                bucket.remove(entry);
                return;
            }
        }
    }

    public static void main(String[] args){
        HashTable hashTable = new HashTable();

        hashTable.put(1,"Hello");
        hashTable.put(2, "Hi");
        hashTable.put(3, "Goodbye");

        hashTable.put(2, "Goodnight");

        System.out.println(hashTable.get(2));
        System.out.println(hashTable.get(3));

        hashTable.remove(2);
        System.out.println(hashTable.get(2));
    }
}
