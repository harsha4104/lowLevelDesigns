package HashSetLLD;

public interface Set<K> {

    void add(K key);

    void remove(K key);

    boolean contains(K key);

    int size();

}
