package CacheLLD;

import CacheLLD.EvictionPolicies.EvictionPolicy;
import CacheLLD.EvictionPolicies.LeastRecentlyUsedPolicy;
import CacheLLD.Exceptions.CacheIsFullException;
import CacheLLD.Exceptions.KeyNotFoundException;
import CacheLLD.cache.Cache;
import CacheLLD.cache.iCache;
import CacheLLD.storage.HashMapBasedStorage;
import CacheLLD.storage.Storage;

public class Executor {

    public static void main(String[] args) throws CacheIsFullException, KeyNotFoundException {

        EvictionPolicy<Integer> evictionPolicy = new LeastRecentlyUsedPolicy<Integer>();

        Storage<Integer, Integer> storage = new HashMapBasedStorage<>(3);

        iCache cache = new Cache(storage, evictionPolicy);

        cache.put(1,5);

        cache.put(2,6);

        cache.put(1,7);

        cache.put(4,8);

        System.out.println(cache.get(4));

        cache.put(5,10);
        System.out.println(cache.get(2));
    }
}
