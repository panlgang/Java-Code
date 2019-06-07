package Heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 基于数组实现小根堆
 * @auther plg
 * @date 2019/6/7 9:42
 */
public class SmallHeap <T> {
    private T[] element;
    private int size;
    private Comparator comparator;
    private static final int DEFAULT_CAPACITY = 10;
    public SmallHeap(){
        this(DEFAULT_CAPACITY,null);
    }
    public SmallHeap(int capacity){
        this(capacity,null);
    }
    public SmallHeap(int capacity,Comparator<T> comparator){
        capacity = capacity > 0 ? capacity : DEFAULT_CAPACITY;
        this.comparator = comparator;
        element = (T[]) new Object[capacity];
    }
    private void grow(){
        int oldCap = element.length;
        int newCap = oldCap + (oldCap < 64 ? oldCap : oldCap >> 1);
        if(newCap > Integer.MAX_VALUE){
            throw new RuntimeException("扩容失败newCap:" +  newCap);
        }
        element = Arrays.copyOf(element,newCap);
    }
    public void add(T t){
        if(element.length == size){
            grow();
        }
        element[size++] = t;
        shiftUp(size - 1);
    }
    public T extraMin(){
        if(size > 0){
            T ret = element[0];
            swap(element,0,--size);
            shiftDown(0);
            return ret;
        }
        return null;
    }
    public T getMin(){
        if(size > 0){
            return element[0];
        }
        return null;
    }

    private void shiftDown(int k) {
        while(2 * k + 1 < size){
            int j = 2 * k + 1;
            if(j + 1 < size){
                j = compare(element[j],element[j+1]) < 0 ? j : j+1;
            }
            if(compare(element[j],element[k]) >= 0) {
                break;
            }
            swap(element,j,k);
            k = j;
        }
    }

    private void shiftUp(int k) {
        while(k > 0 && compare( element[k],element[(k - 1) / 2]) < 0) {
            swap(element,k,(k - 1) / 2);
            k = (k - 1) / 2;
        }
    }

    private void swap(T[] element, int i, int j) {
        T temp = element[i];
        element[i] = element[j];
        element[j] = temp;

    }

    private int compare(T t1,T t2){
        return comparator == null ? ((Comparable<T>) t1).compareTo(t2) : comparator.compare(t1,t2);
    }

    public String toString(){
        StringBuilder ret =  new StringBuilder();
        for(int i = 0; i < size; i++){
            ret.append(element[i] + " ");
        }
        return ret.toString();
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public int getSize(){
        return this.size;
    }


}
