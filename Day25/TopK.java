package Day25;

import java.util.PriorityQueue;

/**
 * 剑指offer30 最小的K个数
 * -  partition 过程
 * -  建一个k个容量的大根堆
 * @auther plg
 * @date 2019/7/5 22:11
 */
public class TopK {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,7,2,3,5,8,0,1};
        int[] ret = heap(arr,4);
        for(int data : ret){
         System.out.println(data);
       }
    }
    public static int[] TopK(int[] arr,int k){
        if(arr == null || arr.length == 0 || k < 0 || k >= arr.length) {
            return new int[]{};
        }
        int index = partition(arr,0,arr.length - 1);
        while(index != k - 1){
           if(index > k - 1){
               index = partition(arr,0,index - 1);
           }else{
               index = partition(arr,index + 1,arr.length -  1);
           }
        }
        int[] ret = new int[k];
        for(int i = 0; i <= index ;i++){
            ret[i] = arr[i];
        }
        return ret;
    }
    public static int partition(int[] arr,int l,int r){
        int temp = arr[r];
        int less = l - 1;
        int more = r + 1 ;
        while(l < more){
            if(arr[l] < temp){
                swap(arr,++less,l++);
            }else if(arr[l] == temp){
                l++;
            }else{
                swap(arr,l,--more);
            }
        }
        return less+1;
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] heap(int[] arr,int k){
        // 默认是小根堆，比较器弄成大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1,num2)->{return num2 - num1;});
        for(int i = 0; i < k; i++){
            queue.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++){
            if(arr[i] < queue.peek()){
                queue.poll();
                queue.add(arr[i]);
            }
        }
        int[] ret = new int[k];
        int i = 0;
        while(!queue.isEmpty()){
            ret[i++] = queue.poll();
        }
        return ret;

    }
}
