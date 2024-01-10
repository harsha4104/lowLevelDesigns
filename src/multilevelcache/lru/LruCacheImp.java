package multilevelcache.lru;

import multilevelcache.eviction.EvictionPolicy;
import multilevelcache.eviction.EvictionPolicyImpl;
import multilevelcache.storage.*;

public class LruCacheImp<K, V> implements Lrucache<K, V> {
    int capacity;
    Storage<K, V> storage;
    EvictionPolicy<K> evictionPolicy;

    public LruCacheImp(int capacity, Storage storage, EvictionPolicy evictionPolicy){
        this.capacity = capacity;
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }
    @Override
    public void put(K key, V value) {
        if(capacity == 0){
            K evictKey = evictionPolicy.evictKey();
            storage.remove(evictKey);
            capacity += 1;
        }
        evictionPolicy.keyAccess(key);
        storage.add(key, value);
        capacity = capacity-1;
    }

    @Override
    public V get(K key) {
        evictionPolicy.keyAccess(key);
        return storage.get(key);
    }
}
