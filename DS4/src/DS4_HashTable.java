import java.util.ArrayList;
import java.util.Iterator;

public class DS4_HashTable<K,V> implements DS4_HashTable_Interface<K,V> {
    private ArrayList<ArrayList<DS4_Entry<K,V>>> hashtable;
    private int loadFactor;
    private int tombStones;
    public DS4_HashTable(int bucketCapacity, int loadFactor, int tableSize)
    {
        hashtable = new ArrayList<>(tableSize);
        this.loadFactor=loadFactor;
        for (int i = 0; i < hashtable.size(); i++) {
            hashtable.set(i, new ArrayList<>(bucketCapacity));
        }
    }


    @Override
    public void clear() {
        for (int i = 0; i < hashtable.size(); i++) {
            for (int j = 0; j < hashtable.get(i).size(); j++) {
                hashtable.get(i).set(j, null);
            }
        }
    }

    @Override
    public int size() {
        int size =0;
        for (int i = 0; i < hashtable.size(); i++) {
            for (int j = 0; j < hashtable.get(i).size(); j++) {
                if (hashtable.get(i).get(j) != null){
                    size++;
                }
            }
        }
        return size;
    }

    @Override
    public int tombstones() {
        return tombStones;
    }

    @Override
    public boolean contains(K key) {
        for (int i = 0; i < hashtable.size(); i++) {
            for (int j = 0; j < hashtable.get(i).size(); j++) {
                if (hashtable.get(i).get(j).equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V insert(K key, V value) {
        if (!hashtable.get(hash(key)).contains(null)){

        }
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }
    public int tableSize(){
        return hashtable.size();
    }
    public Iterator<K> iterator() {
        return null;
    }
    private int hash(K key){
        return key.hashCode()%tableSize();
    }
}
