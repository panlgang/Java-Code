package www.test;

import java.util.Arrays;

public class SequenceBaseArray implements Sequence {
    private  Object[] arr;
    private  int size = 0;
    private final static int DEFAULT_CAPACITY = 10;
    private int maxCapacity = Integer.MAX_VALUE - 10;

    private boolean rangeCheck(int index){
        if(index < 0 || index >= this.size){
            throw new ArrayIndexOutOfBoundsException("下标不合法" + index);
        }
        return true;
    }

    private void encoreCapacity(){
        if(1 + this.size > arr.length / 2 && 2 * this.arr.length < maxCapacity){
            grow();
        }
    }

    private void grow(){
        this.arr = Arrays.copyOf(this.arr,this.arr.length * 2);
    }

    public SequenceBaseArray(){
        arr = new Object[DEFAULT_CAPACITY];
    }

    public SequenceBaseArray(int cap){
        if(cap > 0) {
            arr = new Object[cap];
        }
    }
    @Override
    public void add(Object data) {
        encoreCapacity();
        arr[size++] = data;

    }

    @Override
    public boolean delete(int index) {
        if(rangeCheck(index)){
            if(index == this.size - 1){
                arr[--size] = null;
            }else{
            System.arraycopy(this.arr,index + 1,this.arr,index,this.size - index -1);
            size--;
            }
            return true;
        }
        return false;
    }

    @Override
    public int find(Object obj) {
        for(int i = 0; i < this.size; i++){
            if(obj == null && arr[i] == null){
                return i;
            }
            if(obj != null && obj.equals(arr[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object obj) {
        return this.find(obj) >= 0;
    }

    @Override
    public Object set(int index, Object obj) {
        Object ret = null;
        if(rangeCheck(index)){
            ret = arr[index];
            arr[index] = obj;
        }
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        for(int i = 0; i < this.size; i++){
            arr[i] = null;
        }
        this.size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public Object[] toArray(){
        return this.arr;
    }

    public void printArr(){
        System.out.print("[");
       for(int i = 0; i < this.size; i++){
           System.out.print(arr[i] + "、");
       }
        System.out.println("]");
    }
    
}

