package CacheLLD.DoublyLinkedList;

public class DoublyLinkedListNode<K>{

    DoublyLinkedListNode<K> pre;
    K key;

    DoublyLinkedListNode<K> next;

    public DoublyLinkedListNode(K key){
        this.key = key;
        this.pre = null;
        this.next = null;
    }
}
