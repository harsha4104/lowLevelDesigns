package multilevelcache.storage;

import java.util.*;

public class StorageImpl<K,V> implements Storage<K, V>{

    Map<K, V> map;

    public StorageImpl(){
        this.map = new HashMap<>();
    }
    @Override
    public void add(K k, V v) {
        map.put(k, v);
    }

    @Override
    public V get(K k) {
        if(map.containsKey(k)){
            return map.get(k);
        }
        return null;
    }

    @Override
    public void remove(K k) {
        if(map.containsKey(k)){
            map.remove(k);
        }
    }
}
