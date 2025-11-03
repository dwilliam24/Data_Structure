import java.util.ArrayList;
import java.util.Iterator;

public class DS4_HashTable<K,V> implements DS4_HashTable_Interface<K,V> {
    private ArrayList<ArrayList<DS4_Entry<K,V>>> table;
    private int loadFactor;
    private int tombStones;
    public DS4_HashTable(int bucketCapacity, int loadFactor, int tableSize)
    {
        table = new ArrayList<>();
        this.loadFactor=loadFactor;
        for (int i = 0; i < tableSize; i++) {
            table.add(i, new ArrayList<>(bucketCapacity));
            for (int j = 0; j < table.get(i).size(); j++) {
                table.get(i).set(j,null);
            }
        }
    }


    @Override
    public void clear() {
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                table.get(i).set(j, null);
            }
        }
    }

    @Override
    public int size() {
        int size =0;
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                if (table.get(i).get(j) != null){
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
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                if (table.get(i).get(j).equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V insert(K key, V value) {
            for (int i = 0; i < table.get(hash(key)).size(); i++) {
                if (table.get(hash(key)).get(i).key.equals(key)){
                    V temp = table.get(hash(key)).get(i).value;
                    table.get(hash(key)).set(i,new DS4_Entry<>(key, value));

                    return temp;
                }
                else if (table.get(hash(key)).get(i)==null){
                    V temp = table.get(hash(key)).get(i).value;
                    table.get(hash(key)).set(i, new DS4_Entry<>(key,value));
                    return temp;
                }
            }
            rebuild();
        return null;
    }

    @Override
    public V remove(K key) {
        for (int i = 0; i < table.get(hash(key)).size(); i++) {
            if (table.get(hash(key)).get(i).key.equals(key)){
                V temp = table.get(hash(key)).get(i).value;
                table.get(hash(key)).set(i,null);
                tombStones++;
                return temp;
            }
        }
        return null;
    }
    public int tableSize(){
        return table.size();
    }
    public Iterator<K> iterator() {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < tableSize(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                    keys.add(table.get(i).get(j).key);
            }
        }
        Iterator<K> iterator = keys.iterator();
        return iterator;
    }
    private int hash(K key){
        return key.hashCode()%tableSize();
    }
    private void rebuild(){
        ArrayList<ArrayList<DS4_Entry<K,V>>> temp = new ArrayList<>();
        for (int i = 0; i < tableSize()*2; i++) {

            temp.add(new ArrayList<>());

            for (int j = 0; j < table.get(0).size(); j++) {
                if(i<tableSize()){
                    temp.get(i).add(table.get(i).get(j));
                }
                else temp.get(i).add(null);
            }
        }
        table=temp;
        loadFactor=loadFactor*2;
    }
}
