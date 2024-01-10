package HashMapLLD;

import java.util.*;

public class MapImpl<K, V> implements Map<K, V>{

    int capacity;

    int count;
    double loadFactor;

    List<EntrySet<K,V>> entrySetList;

    public MapImpl(int capacity, double loadFactor){
        this.capacity = capacity;
        count = 0;
        this.loadFactor = loadFactor;
        entrySetList = new ArrayList<>();
        for(int i=0;i<capacity;i++){
            entrySetList.add(null);
        }
    }
    @Override
    public void put(K key, V value) {

        if(count == (int)(loadFactor*capacity)){
            resize();
        }
        int hashKey = hash(key);

        EntrySet<K, V> entrySet = entrySetList.get(hashKey);

        while(entrySet != null){
            if(entrySet.getKey() == key){
                entrySet.setValue(value);
                return;
            }
            entrySet = entrySet.next;
        }

        entrySet = new EntrySet<>(key, value);
        count++;
        entrySet.next = entrySetList.get(hashKey);
        entrySetList.set(hashKey, entrySet);
    }

    @Override
    public V get(K key) {
        int hashKey = hash(key);

        EntrySet<K, V> entrySet = entrySetList.get(hashKey);

        while(entrySet != null){
            if(entrySet.getKey() == key){
                return entrySet.getValue();
            }
            entrySet = entrySet.next;
        }

        return null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void remove(K key) {
        int hashKey = hash(key);

        EntrySet<K, V> entrySet = entrySetList.get(hashKey);
        if(entrySet.getKey() == key){
            entrySetList.set(hashKey, entrySet.next);
            count--;
            return;
        }

        while(entrySet.next != null){
            if(entrySet.next.getKey() == key){
                entrySet.next = entrySet.next.next;
                count--;
                break;
            }
            entrySet = entrySet.next;
        }
    }

    @Override
    public boolean containsKey(K key) {
        int hashKey = hash(key);

        EntrySet<K, V> entrySet = entrySetList.get(hashKey);

        while(entrySet != null){
            if(entrySet.getKey() == key){
                return true;
            }
            entrySet = entrySet.next;
        }

        return false;
    }

    private int hash(K key){
        int hashKey = key.hashCode()%capacity;
        return hashKey;
    }

    private void resize(){
        List<EntrySet<K,V>> newList = new ArrayList<>();
        for(int i=0;i<2*capacity;i++){
            newList.add(null);
        }
        int previousCapacity = capacity;
        this.capacity = 2*capacity;
        for(int i=0;i<previousCapacity;i++){
            EntrySet<K, V> entrySet = entrySetList.get(i);

            while(entrySet != null){
                int hashKey = hash(entrySet.getKey());
                EntrySet<K, V> next = entrySet.next;
                entrySet.next = newList.get(hashKey);
                newList.set(hashKey, entrySet);
                entrySet = next;
            }
        }

        this.entrySetList = newList;
    }
}
