package CacheLLD.storage;

import CacheLLD.Exceptions.KeyNotFoundException;

import java.util.*;

public class HashMapBasedStorage<K, V> implements Storage<K, V> {

    Map<K, V> map= new HashMap<K, V>();
    int capacity;

    public HashMapBasedStorage(Integer capacity){
        this.capacity = capacity;
    }
    @Override
    public void put(K key, V value){
        map.put(key, value);
        capacity--;
    }

    @Override
    public void remove(K key) throws KeyNotFoundException {
        if(map.containsKey(key)) {
            map.remove(key);
        }
        else{
            throw new KeyNotFoundException(key+" doesn't exists");
        }
    }

    @Override
    public V get(K key) throws KeyNotFoundException {
        if(map.containsKey(key)){
            return map.get(key);
        }
        else{
            throw new KeyNotFoundException(key+" doesn't exists");
        }
    }

    @Override
    public boolean isFull() {
        return capacity == 0 ? true : false;
    }
}
