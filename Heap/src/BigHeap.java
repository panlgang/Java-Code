import java.util.Arrays;

/**
 * @auther plg
 * @date 2019/3/22 17:21
 * 基于数组实现大根堆
 */
public class BigHeap {
    private int capacity;
    private int[] arr;
    private int count;

    /**
     * 扩容
     * @param arr
     * @param capacity
     */
    private void expand(int[] arr,int capacity){
        this.arr = Arrays.copyOf(arr,capacity << 1);
    }
    //插入后向上调整
    private void shiftUp(int[] arr,int count){
        while(count > 0 && arr[count] > arr[(count - 1) / 2]){
            swap(arr,count,(count - 1) / 2);
            count = (count -  1) / 2;
        }
    }
    private void swap(int[] arr,int i,int j){
        if(i != j){
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }
    // 弹出最大值后，向下调整
    private void shiftDown(int k){
        while(2 * k + 1 < count){
            int j = 2 * k + 2;
            if(j < count){
                j = arr[j] > arr[j - 1] ? j : j - 1;
            }
            if(arr[j] <= arr[k]){
                break;
            }
            swap(arr,j,k);
            k = j;
        }
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public BigHeap(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.count = 0;
    }
    public void insert(int data){
        if(count >= (capacity >> 1)){
            expand(arr,capacity);
        }
        arr[count++] = data;
        shiftUp(arr,count-1);
    }
    public int exteraMax(){
        int max = arr[0];
        swap(arr,0,--count);
        shiftDown(0);
        return max;
    }
    public int[] toArray(){
        int[] ret = new int[count];
        ret = Arrays.copyOf(this.arr,count);
        return ret;
    }

}
