package multilevelcache.storage;

public interface Storage<K, V> {

    void add(K k, V v);

    V get(K k);

    void remove(K k);
}
