package CacheLLD.DoublyLinkedList;

public class DoublyLinkedList<K> {

    DoublyLinkedListNode<K> head;

    DoublyLinkedListNode<K> tail;

    public DoublyLinkedList(){
        this.head = null;
    }

    public DoublyLinkedListNode<K> addElement(K key){
        DoublyLinkedListNode<K> node = new DoublyLinkedListNode<K>(key);
        addNodeAtLast(node);
        return node;
    }

    public void detachNode(DoublyLinkedListNode<K> node){
        if(node == head && tail == head){
            head = null;
            tail = null;
        }
        else if(node == head){
            head = head.next;
        }
        else if(tail == node){
            tail = tail.pre;
        }
        else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    public void addNodeAtLast(DoublyLinkedListNode<K> node){
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            node.pre = tail;
            tail = tail.next;
        }
    }

    public K getFirstKey(){
        K key = head.key;
        head = head.next;
        if(head == null){
            tail = null;
        }

        return key;
    }
}
