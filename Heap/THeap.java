package Heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @auther plg
 * @date 2019/6/6 19:44
 */
public class THeap<T>  {
    private T element[];
    private int size;
    private Comparator<T> comparator;
    private  static final int DEFAULT_CAPACITY = 10;
    public THeap(){
        this(DEFAULT_CAPACITY,null);
    }
    public THeap(int capacity){
        this(capacity,null);
    }
    public THeap( int capacity, Comparator<T> comparator) {

        this.element = (T[]) new Object[capacity];
        this.comparator = comparator;
    }
    private void grow(){
        int oldCap = element.length;
        int newCap = oldCap + (oldCap < 64 ? oldCap : oldCap >> 1);
        if(newCap > Integer.MAX_VALUE - 8){
            throw new IllegalArgumentException("数组太大了");
        }
        element = Arrays.copyOf(element,newCap);
    }
    public void add(T t){
        if(size == element.length){
            grow();
        }
        element[size++] = t;
        shiftUp(size - 1);
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public String toString(){
        StringBuilder ret =  new StringBuilder();
        for(int i = 0; i < size; i++){
            ret.append(element[i] + " ");
        }
        return ret.toString();
    }

    public  T extractMax(){
        T ret = null;
        if(size > 0){
            ret = element[0];
            swap(element,0,--size);
            shiftDown(0);
        }
        return ret;
    }

    private void shiftDown(int k) {
        while((2 * k + 1) < size){
            int j = 2 * k + 1;
            if(j + 1 < size){
                j = compare(element[j+1],element[j]) > 0 ? j+1 : j;
            }
            // j 此时已经是 左右孩子最大值的下标
            if(compare(element[k],element[j]) > 0){
                break;
            }
            swap(element,k,j);
            k = j;
        }
    }

    private void shiftUp(int k) {
        while(k > 0 && compare(element[k],element[(k - 1) / 2]) > 0){
            swap(element,k,(k-1) /2);
            k = (k -1) / 2;
        }
    }

    private int compare(T t1, T t2) {
        return comparator == null ?  ((Comparable<T>) t1).compareTo(t2): comparator.compare(t1,t2);
    }

    private void swap(T element[] ,int k, int i) {
        T temp = element[k];
        element[k] = element[i];
        element[i] = temp;
    }



}
