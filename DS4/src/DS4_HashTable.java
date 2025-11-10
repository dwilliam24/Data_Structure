import java.util.ArrayList;
import java.util.Iterator;

public class DS4_HashTable<K,V> implements DS4_HashTable_Interface<K,V> {
    private ArrayList<ArrayList<DS4_Entry<K,V>>> table;
    private int loadFactor;
    private int tableSize;
    private int bucketCapacity;
    private int tombStones;
    public DS4_HashTable(int bucketCapacity, int loadFactor, int tableSize)
    {
        table = new ArrayList<>();
        this.loadFactor=loadFactor;
        this.bucketCapacity=bucketCapacity;
        this.tableSize=tableSize;
        for (int i = 0; i < tableSize; i++) {
            table.add(i, new ArrayList<>());
        }
    }


    @Override
    public void clear() {
        for (int i = 0; i < table.size(); i++) {
            table.get(i).clear();
        }
        tombStones=0;
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
                if (table.get(i).get(j)!=null&&table.get(i).get(j).key.equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V insert(K key, V value) {
        int loc = hash(key);
        for (int j = loc; j <tableSize()+loc; j++) {
            for (int i = 0; i < table.get(j%tableSize()).size(); i++) {
                if (table.get(j%tableSize()).get(i)!=null&&table.get(j%tableSize()).get(i).key.equals(key)){
                    V temp = table.get(j%tableSize()).get(i).value;
                    table.get(j%tableSize()).set(i,new DS4_Entry<>(key, value));
                    return temp;
                }
            }
            for (int i = 0; i < table.get(j%tableSize()).size(); i++) {
                    if (table.get(j%tableSize()).get(i)==null){
                    table.get(j%tableSize()).set(i,new DS4_Entry<>(key, value));
                    return null;
                }
            }
            if (table.get(j%tableSize()).size()<bucketCapacity){
                table.get(j%tableSize()).add(new DS4_Entry<>(key,value));
                int tracker=0;
                Iterator<K> iterator = iterator();
                while (iterator.hasNext()){
                    tracker++;
                    iterator.next();
                }
                if (tracker>=loadFactor) {
                    rebuild();
                }
                return null;
            }
        }
        int tracker=0;
        Iterator<K> iterator = iterator();
        while (iterator.hasNext()){
            tracker++;
            iterator.next();
        }
        if (tracker>=loadFactor) {
            rebuild();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int loc = hash(key);
        for (int j = loc; j <tableSize()+loc; j++) {
            for (int i = 0; i < table.get(j%tableSize()).size(); i++) {
                if (table.get(j%tableSize()).get(i)!=null&&table.get(j%tableSize()).get(i).key.equals(key)) {
                    V temp = table.get(j%tableSize()).get(i).value;
                    table.get(j%tableSize()).set(i, null);
                    tombStones++;
                    return temp;
                }
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
                    if (table.get(i).get(j)==null){
                        keys.add(null);
                    }
                    else keys.add(table.get(i).get(j).key);
            }
        }
        Iterator<K> iterator = keys.iterator();
        return iterator;
    }

    private int hash(K key){
        return key.hashCode()%tableSize;
    }
    private void rebuild(){
        loadFactor=loadFactor*2;
        tombStones=0;
        tableSize*=2;
        ArrayList<DS4_Entry> temp = new ArrayList<>();
        ArrayList<ArrayList<DS4_Entry<K,V>>> newTable = new ArrayList<>();

        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                if (table.get(i).get(j)!=null)
                    temp.add(table.get(i).get(j));
            }
        }
        for (int i = 0; i < table.size()*2; i++) {
            newTable.add(new ArrayList<>());
        }

        for (int n = 0; n < temp.size(); n++) {
            K key = (K) temp.get(n).key;
            V value = (V) temp.get(n).value;

            int loc = key.hashCode()% newTable.size();
            for (int j = loc; j <newTable.size()+loc; j++) {
                if (newTable.get(j%tableSize()).size()<bucketCapacity){
                    newTable.get(j%tableSize()).add(new DS4_Entry<>(key,value));
                    break;
                }
            }
        }
        table=newTable;
    }
}
//     (^._.^)ﾉ