package multilevelcache.eviction;

public interface EvictionPolicy<K> {

    void keyAccess(K k);

    K evictKey();

    void removeNode(K key);
}
