package CacheLLD.EvictionPolicies;

public interface EvictionPolicy<K> {

    void keyAccessed(K key);

    K evictKey();
}
