package multilevelcache.mlevelcache;

public interface MultiLevelCache<K, V>{

    void put(K key, V value);

    V get(K key);
}
