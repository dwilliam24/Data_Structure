import java.util.Iterator;

public class DS4_HashTable<K,V> implements DS4_HashTable_Interface<K,V> {

    public DS4_HashTable(K bucketCapacity, K loadFactor, K tableSize)
    {

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
    public boolean contains(Object key) {
        return false;
    }

    @Override
    public Object insert(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
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
