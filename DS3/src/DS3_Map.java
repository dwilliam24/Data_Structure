import java.util.ArrayList;
import java.util.Iterator;

public class DS3_Map<K,V> implements MapInterface<K,V>{
    private ArrayList<MapEnt> data;

    public DS3_Map() {
        data=new ArrayList<>();
    }

    public Iterator<MapEnt> iterator()
    {
        return data.iterator();
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public boolean containsKey(K key) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getKey().equals(key)) return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getValue().equals(value)) return true;
        }
        return false;
    }

    @Override
    public DS3_Set<MapEnt<K, V>> entrySet() {
        DS3_Set a = new DS3_Set();
        for (int i = 0; i < data.size(); i++) {
            a.add(data.get(i));
        }
        return a;
    }

    @Override
    public V get(K o) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getKey().equals(o)) return (V) data.get(i).getValue();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public V put(K key, V value) {
        MapEnt a = new MapEnt(key, value);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getKey().equals(key))
            {
                V g = (V) data.remove(i).getValue();
                data.add(a);
                return g;
            }
        }
        data.add(a);
        return null;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public DS3_Set keySet() {
        DS3_Set a = new DS3_Set();
        for (int i = 0; i < data.size(); i++) {
            a.add(data.get(i).getKey());
        }
        return a;
    }

    @Override
    public ArrayList values() {
        ArrayList<V> a = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            a.add((V) data.get(i).getValue());
        }
        return a;
    }

    @Override
    public V remove(K key) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getKey().equals(key))
            {
                return (V) data.remove(i).getValue();
            }
        }
        return null;
    }
}
