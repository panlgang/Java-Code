package www.review.java;

public class MaxHeap {
    private int capacity ;  //容量
    private int[] arr ;
    private int count;

    //调整
    private void shiftUp(int k){
        //k == 1时已经时根节点不需要再进行比较

        while(k > 1 && arr[k/2] < arr[k]){
            Swap.swap(arr,k/2,k);
            k /= 2;
        }
    }
    private void shiftDown(int k){
        while(2*k < count){
            int j = 2*k;
            if( j+1 < count && arr[j+1] > arr[j]){
                j += 1;
            }
            if(arr[k] > arr[j]){
                break;
            }
            Swap.swap(arr,k,j);
            k = j;
        }
    }
    public MaxHeap(int capacity){
        this.capacity = capacity + 1;   //根节点存放的下标为1
        arr = new int[this.capacity];
        this.count = 0;
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public void insert(int data){
        if(count++ < capacity) {
            arr[count++] = data;  //放在末尾，然后调整
            shiftUp(count);
        }
    }
    public int  pushRoot(){
        int ret = arr[1];
        Swap.swap(arr,1,count--);
        shiftDown(1);
        return ret;
    }
}
