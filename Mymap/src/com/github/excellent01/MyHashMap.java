package com.github.excellent01;

import java.util.*;

/**
 * 模拟实现Hashmap（数组 + 链表）--- 没有树化
 * @auther plg
 * @date 2019/4/15 15:46
 */
public class MyHashMap<K,V> implements MyMap<K,V>{
    private int i = 0;
    private Node<K,V>[] table;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LODE_FACTOR = 0.75f;
    private int capacity ;
    private int size;
    public MyHashMap(){
        this.table = new Node[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    static class Node<K,V>{
        private K key;
        private V val;
        private int hash;
        private Node<K,V> next;
        public Node(K key,V val,int hash){
            this.key = key;
            this.val = val;
            this.hash = hash;
            next = null;
        }
    }
    @Override
    public void put(K key, V val) {
         ensureCapacity();
         int hash = myHash(key);
         Node node = new Node(key,val,hash);
         int index = myIndex(hash);
         if(table[index] == null){
            table[index] = node;
        }else{
            Node temp = table[index];
            boolean isReapted = false;
            while(temp.next != null){
                if(temp.hash == hash){
                    temp.val = val;
                    isReapted = true;
                    break;
                }
                temp = temp.next;
            }
            if(! isReapted){
                temp.next = node;
            }
        }
        size++;
    }

    @Override
    public V get(K key) {
        int hash = myHash(key);
        int index = myIndex(hash);
        Node<K,V> ret = table[index];   // 需加泛型，否则返回Object类型
        while(ret != null){
            if(ret.hash == hash){
                return ret.val;
            }
            ret = ret.next;
        }
        return null;
    }
    public int myHash(K key){
        int h;
        return  key == null ? 0 : (h = key.hashCode()) ^ (h >>>16) ;
    }
    public int myIndex(int hash){
        return hash & (capacity - 1);
    }
    public int getSize(){
        return this.size;
    }
    public Set<K> mykeySet(){
        HashSet<K> hashSet = new HashSet<>();
        for(int i = 0; i < capacity; i++){
           Node<K,V> temp = table[i];
           while(temp != null){
               hashSet.add(temp.key);
               temp = temp.next;
           }
        }
        return hashSet;
    }
    public Collection<V> values(){
        List<V> list = new ArrayList<>();
        for(int i = 0; i < capacity; i++){
            Node<K,V> temp = table[i];
            while(temp != null){
                list.add(temp.val);
                temp = temp.next;
            }
        }
        return list;
    }
    public V setValue(K key,V value){
        int hash = myHash(key);
        int index = myIndex(hash);
        Node<K,V> temp = table[index];
        V ret = null;
        while(temp != null){
            if(temp.hash == hash){
                ret = temp.val;
                temp.val = value;
                return ret;
            }
            temp = temp.next;
        }
        return null;
    }
    private void ensureCapacity(){
        if(size + 1 > (int)(capacity * LODE_FACTOR)){
            grow();
        }
    }
    private void grow(){
        int newCapacity = 1 << this.capacity;
        this.table = Arrays.copyOf(table,newCapacity);
    }
}
