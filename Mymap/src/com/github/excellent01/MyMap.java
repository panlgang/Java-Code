package com.github.excellent01;


import java.util.Collection;
import java.util.Collections;

public interface MyMap<K,V> {
    /**
     * 添加数据对
     * @param key
     * @param val
     */
    void put(K key,V val);

    /**
     * 根据key值查找
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 修改value值
     * @param key
     * @param value
     * @return
     */
    V setValue(K key,V value);

    /**
     * 取出所有value值
     * @return
     */
    Collection<V> values();

    /**
     * 根据key值计算hash值
     * @param key
     * @return
     */
    int myHash(K key);

    /**
     * 根据hash值计算下标
     * @param hash
     * @return
     */
    int myIndex(int hash);
    int getSize();
}
