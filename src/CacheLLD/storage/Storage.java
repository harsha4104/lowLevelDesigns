package CacheLLD.storage;

import CacheLLD.Exceptions.KeyNotFoundException;

public interface Storage<K, V>{

    void put(K key, V value);

    void remove(K key) throws KeyNotFoundException;

    V get(K key) throws KeyNotFoundException;

    boolean isFull();
}
