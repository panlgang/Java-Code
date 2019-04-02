import java.util.Arrays;
import java.util.Comparator;

/**
 * @auther plg
 * @date 2019/4/2 20:59
 */
public class SmallHeap {
    private int[] arr;
    private int count;
    private int size;
    public SmallHeap(int size){
        this.size = size;
        this.arr = new int[size];
        this.count = 0;
    }
    public SmallHeap(){
        this.size = 16;
        this.arr = new int[size];
        this.count = 0;
    }
    public boolean add(int value){
        if(count >= this.size){
            expand(arr);
        }
        arr[count++] = value;
        shiftUp(count - 1);
        return true;
    }
    public int exteraMin(){
        int ret = arr[0];
        swap(arr,0,--count);
        shiftDown(0);
        return ret;
    }
    private void shiftUp(int count){
        while(count > 0 && arr[count] < arr[(count -  1) / 2]){
            swap(arr,count,(count - 1) / 2);
            count = (count - 1) / 2;
        }
    }
    private void expand(int[] arr){
        this.arr = Arrays.copyOf(arr,arr.length << 1);
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void shiftDown(int k){
        while(2 * k + 1 < count){
            int j = 2 * k + 2;
            if(j < count){
                j = arr[j] < arr[j - 1] ? j : j - 1;
            }
            if(arr[j] >= arr[k]){
                break;
            }
            swap(arr,j,k);
            k = j;
        }
    }
    public int getCount(){
        return this.count;
    }
    public int[] toArray(){
        return Arrays.copyOf(arr,this.count);
    }

}
