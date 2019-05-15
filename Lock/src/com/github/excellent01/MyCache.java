package com.github.excellent01;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * HashMap +
 * @auther plg
 * @date 2019/5/15 21:54
 */
public class MyCache<K,V>{
    private HashMap<K,V> hashMap = new HashMap<>();
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static Lock readLock = lock.readLock();
    private static Lock writeLock = lock.writeLock();
    public V get(K key){
        try{
            readLock.lock();
            return hashMap.get(key);
        }finally {
            readLock.unlock();
        }
    }
    public void put(K key,V val){
        try{
            writeLock.lock();
            hashMap.put(key,val);
        }finally {
            writeLock.unlock();
        }
    }
}
