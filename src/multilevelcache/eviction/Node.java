package multilevelcache.eviction;

public class Node<K> {

    public Node<K> pre;

    public K key;

    public Node<K> next;

    public Node(K key){
        pre = null;
        this.key = key;
        next = null;
    }
}
