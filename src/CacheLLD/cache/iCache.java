package CacheLLD.cache;

import CacheLLD.Exceptions.CacheIsFullException;
import CacheLLD.Exceptions.KeyNotFoundException;

public interface iCache<K, V> {

    void put(K key, V value) throws KeyNotFoundException, CacheIsFullException;

    V get(K key) throws KeyNotFoundException;
}
