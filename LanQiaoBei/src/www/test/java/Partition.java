package www.test.java;

import static www.test.java.MoveZeros.swap;

public class Partition {
    public static void main(String[] args) {
        int[]arr = {1,8,3,10,10,2,6,4,7,9,20,99,32,10};
        partition_2(arr,10);
        for(int data : arr){
            System.out.print(data + "、");
        }
    }
    public static void partition_1(int[] arr,int key){
        int L = 0;
        int R = arr.length - 1;
        int less = L - 1;
        while(L <= R){
            if(arr[L] <= key){
                swap(arr, ++less,L++);
            }else{
                L++;
            }
        }
    } //小于等于在前，大于在后
    public static void partition_2(int[] arr,int key){
        int L = 0;
        int R = arr.length - 1;
        while(L < R){
            if(arr[L] >= key && arr[R] <= key ){
                swap(arr,L++,R--);
            }
            else if(arr[L] <= key ){
                L++;
            }else if(arr[R] >= key){
                R--;
            }
        }
    } //小于等于在前，大于等于在后

}
