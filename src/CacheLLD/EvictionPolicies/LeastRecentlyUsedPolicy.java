package CacheLLD.EvictionPolicies;

import CacheLLD.DoublyLinkedList.*;
import java.util.*;

public class LeastRecentlyUsedPolicy<K> implements EvictionPolicy<K>{

    DoublyLinkedList<K> dll = new DoublyLinkedList<K>();
    Map<K, DoublyLinkedListNode<K>> map = new HashMap<K, DoublyLinkedListNode<K>>();
    @Override
    public void keyAccessed(K key) {
        if(map.containsKey(key)){
            dll.detachNode(map.get(key));
            dll.addNodeAtLast(map.get(key));
        }
        else{
            DoublyLinkedListNode<K> node = dll.addElement(key);
            map.put(key, node);
        }
    }

    @Override
    public K evictKey() {
        K key = dll.getFirstKey();
        map.remove(key);
        return key;
    }
}
