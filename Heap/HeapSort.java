package Heap;

import java.util.Arrays;
import java.util.Random;

/**
 * @auther plg
 * @date 2019/6/9 18:53
 */
public class HeapSort {

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int len = arr.length;
        for(int i = (len - 2) / 2; i >= 0; i--){
            shiftDown(arr,len,i);
        }
        for(int i = len - 1; i >=0; i--){
            swap(arr,0,i);
            shiftDown(arr,i,0);
        }
    }

    private static void shiftDown(int[] arr, int len, int k) {
        while(2 * k + 1 < len){
            int j = 2 * k + 1;
            if(j + 1 < len){
                j = arr[j + 1] > arr[j] ? j+1 : j;
            }
            if(arr[k] >= arr[j]){
                break;
            }
            swap(arr,j,k);
            k = j;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = genneate(1000000,10000);
        int[] arr2 = copyArr(arr);
        long timeStart = System.currentTimeMillis();
        heapSort(arr);
        for(int i = 0; i < arr.length; i++){
           if(i + 1 < arr.length && arr[i] > arr[i+1]){
               System.out.println("error");
           }
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("堆排序" + (timeEnd - timeStart) + "ms");
        System.out.println("=============================================");
        timeStart = System.currentTimeMillis();
        Arrays.sort(arr2);
        for(int i = 0; i < arr.length; i++){
            if(i + 1 < arr.length && arr[i] > arr[i+1]){
                System.out.println("error");
            }
        }
        timeEnd = System.currentTimeMillis();
        System.out.println("系统排序" + (timeEnd - timeStart) + "ms");
        isRight(arr,arr2);
    }
    public static int[] genneate(int length,int max){
        Random random = new Random();
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = random.nextInt(max);
        }
        return arr;
    }
    public static int[] copyArr(int[] arr){
        int[] ret = new int[arr.length];
        for(int i = 0;i < arr.length; i++){
            ret[i] = arr[i];
        }
        return ret;
    }
    public static void isRight(int[] arr1,int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                System.out.println("error");
                return;
            }

        }
        System.out.println("Nice");
    }


}
