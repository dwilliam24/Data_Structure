import java.util.ArrayList;
import java.util.Iterator;

public class DS4_HashTable<K,V> implements DS4_HashTable_Interface<K,V> {
    private ArrayList<ArrayList<DS4_Entry<K,V>>> Hashtable;
    public DS4_HashTable(int bucketCapacity, int loadFactor, int tableSize)
    {
        Hashtable = new ArrayList<>(tableSize);
        for (int i = 0; i < tableSize; i++) {

        }

    }


    private int hash(K key){
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int tombstones() {
        return 0;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V insert(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }
    public int tableSize(){
        return 0;
    }
    public Iterator<K> iterator()
    {
       return null;
    }
}
