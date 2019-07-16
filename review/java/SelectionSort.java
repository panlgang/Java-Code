package www.review.java;

public class SelectionSort {
    //优化版本
    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++){

            //在[i..arr.length)区间内寻找最小值。
            int minindex = i;
            for(int j = i+1; j < arr.length;j++){
                //mindex存放最小值的下标。
                minindex = arr[minindex] < arr[j] ? minindex : j;
//                if(arr[minindex] > arr[j]){
//                    minindex = j;
//                }
            }
            Swap.swap(arr,i,minindex);
        }
    }
    //基础版本
    public static void selectionSort_1(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[i]){
                    Swap.swap(arr,i,j);
                }
            }
        }
    }

}
