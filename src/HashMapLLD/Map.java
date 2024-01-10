package HashMapLLD;

public interface Map <K, V>{

    void put(K key, V value);

    V get(K key);

    int size();

    void remove(K key);

    boolean containsKey(K key);
}
