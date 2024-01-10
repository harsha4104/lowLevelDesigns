package multilevelcache.lru;

public interface Lrucache<K, V> {


    void put(K key, V value);

    V get(K key);
}
