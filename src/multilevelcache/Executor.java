package multilevelcache;

import multilevelcache.eviction.EvictionPolicy;
import multilevelcache.eviction.EvictionPolicyImpl;
import multilevelcache.mlevelcache.MultiLevelCache;
import multilevelcache.mlevelcache.MultiLevelCacheImpl;
import multilevelcache.storage.Storage;
import multilevelcache.storage.StorageImpl;

public class Executor {

    public static void main(String[] args){

        Storage<Integer, Integer> storage1 = new StorageImpl<>();
        EvictionPolicy<Integer> evictionPolicy1 = new EvictionPolicyImpl<>();

        MultiLevelCache<Integer, Integer> level1 = new MultiLevelCacheImpl<>(3, storage1, evictionPolicy1, null, false);

        Storage<Integer, Integer> storage2 = new StorageImpl<>();
        EvictionPolicy<Integer> evictionPolicy2 = new EvictionPolicyImpl<>();

        MultiLevelCache<Integer, Integer> multiLevelCache = new MultiLevelCacheImpl<>(3, storage2, evictionPolicy2, level1, true);


        multiLevelCache.put(1,1);
        multiLevelCache.put(2,2);
        multiLevelCache.put(3,3);
        multiLevelCache.put(4,4);

        System.out.println(multiLevelCache.get(1));
    }
}
