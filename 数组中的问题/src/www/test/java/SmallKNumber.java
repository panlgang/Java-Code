package www.test.java;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

/**
 * 在一个数组中找出最小的K的个数，不要求有序
 */
public class SmallKNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,6,5,8,4,10};
        int[] ret = findKNumber_2(arr,3);
        for(int data : ret){
            System.out.print(data + "、");
        }

    }

    /**
     * 先排序，然后取出排序数组中的前K个元素
     * @param arr
     * @param k
     * @return
     */
    public static int[] findKNumber_1(int[] arr,int k){
        if(arr == null || arr.length == 0 ){
            throw new RuntimeException("数组不合法！");
        }
        if(arr.length == k){
            return arr;
        }
        if(arr.length > k){
            int[] ret = new int[k];
            Arrays.sort(arr);
            for(int i = 0; i < k; i++){
                ret[i] = arr[i];
            }
            return ret;
        }
        return null;
    }
    public static int[] findKNumber_2(int[] arr,int k){
        if(arr == null || arr.length == 0){
            throw new RuntimeException("数组不合法！");
        }
        int[] ret = new int[k];
        for(int i = 0; i < k; i++){
            ret[i] = arr[i];
        }
        for(int i = 0; i < k; i++){
            int index = getMax(ret);
            for(int j = k; j < arr.length;j++){
                if(arr[index] > arr[j]){
                    swap(arr,index,j);
                    break;
                }
            }
        }
        return ret;
    }
    private static int getMax(int[] arr){
        int max = arr[0];
        int index = 0;
        for(int i = 1; i < arr.length; i++){
            if(max > arr[i]){
                index = i;
            }
        }
        return index;
    }
    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
