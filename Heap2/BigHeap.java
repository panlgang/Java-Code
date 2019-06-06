import java.util.Arrays;

/**
 * 基于数组实现大根堆
 * @auther plg
 * @date 2019/3/22 17:21
 *
 */
public class BigHeap {
    private int capacity;
    private int[] arr;
    private int count;    // 当前数组中的元素个数
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 扩容：一次扩大一倍
     * @param arr
     * @param capacity
     */
    private void expand(int[] arr,int capacity){
        this.arr = Arrays.copyOf(arr,capacity << 1);
    }
    //插入元素后向上调整,形成大根堆结构
    private void shiftUp(int[] arr,int count){
        // 两个条件。
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
    //弹出堆顶元素后向下调整，满足大根堆结构
    private void shiftDown(int k){
        //有左孩子
        while(2 * k + 1 < count){
            int j = 2 * k + 2;
            if(j < count){
                j = arr[j] > arr[j - 1] ? j : j - 1;
            }
            if(arr[j] <= arr[k]){
                break;
            }
            swap(arr,j,k);
            // 继续该过程，继续shiftDown。
            k = j;
        }
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public BigHeap(){
        this.capacity = DEFAULT_CAPACITY;
        this.arr = new int[capacity];
        this.count = 0;
    }
    public BigHeap(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.count = 0;
    }
    public void add(int data){
        if(count + 1 >= capacity){
            expand(arr,capacity);
        }
        arr[count++] = data;
        shiftUp(arr,count-1);   // 减一很关键,此时的参数代表元素下标
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
