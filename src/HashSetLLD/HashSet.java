package HashSetLLD;

import java.util.*;

public class HashSet<K> implements Set<K>{

    Map<K, String> map;

    int capacity;

    float loadFactor;

    public static final String dummy = "PRESENT";

    public HashSet(int capacity, float loadFactor){
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        map = new HashMap<>(capacity, loadFactor);
    }
    @Override
    public void add(K key) {
        if(!map.containsKey(key)){
            map.put(key, dummy);
        }
    }

    @Override
    public void remove(K key) {
        if(map.containsKey(key)){
            map.remove(key);
        }
    }

    @Override
    public boolean contains(K key) {
        if(map.containsKey(key)){
            return true;
        }

        return false;
    }

    @Override
    public int size() {
        return map.size();
    }
}
