package CacheLLD.cache;

import CacheLLD.EvictionPolicies.EvictionPolicy;
import CacheLLD.Exceptions.KeyNotFoundException;
import CacheLLD.storage.Storage;

public class Cache<K, V> implements iCache<K, V>{

    Storage<K, V> storage;
    EvictionPolicy<K> evictionPolicy;

    public Cache(Storage storage, EvictionPolicy evictionPolicy){
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }
    @Override
    public void put(K key, V value) throws KeyNotFoundException {
        if(storage.isFull()){
            K eKey = evictionPolicy.evictKey();
            storage.remove(eKey);
        }

        storage.put(key, value);
        evictionPolicy.keyAccessed(key);
    }

    @Override
    public V get(K key) throws KeyNotFoundException {
        try{
            V value =  storage.get(key);
            evictionPolicy.keyAccessed(key);
            return value;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new KeyNotFoundException("key not found");
        }
    }
}
