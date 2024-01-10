package multilevelcache.mlevelcache;

import multilevelcache.eviction.EvictionPolicy;
import multilevelcache.eviction.Node;
import multilevelcache.storage.Storage;

public class MultiLevelCacheImpl<K, V> implements MultiLevelCache<K, V>{

    int capacity;

    final boolean topLevel ;
    Storage<K, V> storage;
    EvictionPolicy<K> evictionPolicy;

    MultiLevelCache<K, V> next;

    public MultiLevelCacheImpl(int capacity, Storage storage, EvictionPolicy evictionPolicy, MultiLevelCache multiLevelCache, boolean topLevel){
        this.capacity = capacity;
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
        this.next = multiLevelCache;
        this.topLevel = topLevel;
    }
    @Override
    public void put(K key, V value) {
        if(capacity > 0){
            evictionPolicy.keyAccess(key);
            storage.add(key, value);
            capacity = capacity-1;
        }
        else{
            K evictKey = evictionPolicy.evictKey();
            storage.add(key, value);
            evictionPolicy.keyAccess(key);
            next.put(evictKey, storage.get(evictKey));
            storage.remove(evictKey);
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        if(storage.get(key) != null){
            value = storage.get(key);
            storage.remove(key);
            evictionPolicy.removeNode(key);
        }

        if(next != null){
            value = next.get(key);
        }

        if(next == null && value == null){
            return null;
        }

        if(topLevel && value != null){
            put(key, value);
        }

        return value;
    }
}
