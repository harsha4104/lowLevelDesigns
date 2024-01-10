package multilevelcache.eviction;

import java.util.*;
public class DoublyLinkedListImpl<K> {

    Node<K> head;
    Node<K> tail;


    public DoublyLinkedListImpl(){
        head = null;
        tail = null;
    }

    public void addNodeLast(Node<K> node){
        if(head == null){
            head = node;
            tail = head;
        }
        else{
            tail.next = node;
            node.pre = tail;
            tail = tail.next;
        }
    }

    public void removeNodeFromMiddle(Node<K> node){
        if(node == head){
            head = head.next;
            if(head == null){
                tail = null;
            }
            addNodeLast(node);
        }
        else if(node != tail){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            addNodeLast(node);
        }
    }

    public K removeFromHead(){
        Node<K> node = head;
        head = head.next;
        if(head == null){
            tail = null;
        }

        return node.key;
    }

    public void removeNode(Node<K> node){
        if(node.pre != null && node.next != null){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        else if(node.next != null){
            node.next.pre = null;
        }
        else if(node.pre != null){
            node.pre.next = null;
        }
    }
}
