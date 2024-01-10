package multilevelcache.eviction;

import java.util.*;
public class EvictionPolicyImpl<K> implements EvictionPolicy<K>{

    DoublyLinkedListImpl<K> doublyLinkedList;

    Map<K, Node<K>> map;
    public EvictionPolicyImpl(){
        doublyLinkedList = new DoublyLinkedListImpl<>();
        map = new HashMap<>();
    }
    @Override
    public void keyAccess(K k) {
        if(map.containsKey(k)){
            doublyLinkedList.removeNodeFromMiddle(map.get(k));
        }
        else{
            Node<K> node = new Node(k);
            doublyLinkedList.addNodeLast(node);
            map.put(k, node);
        }
    }

    @Override
    public K evictKey() {
        K key = doublyLinkedList.removeFromHead();
        map.remove(key);
        return key;
    }

    @Override
    public void removeNode(K key) {
        doublyLinkedList.removeNode(map.get(key));
    }
}
