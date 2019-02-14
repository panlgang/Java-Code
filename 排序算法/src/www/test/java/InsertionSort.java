package www.test.java;

public class InsertionSort {
    public static void insertionSort_1(int[] arr){
        for(int i = 1; i < arr.length; i++){

            //j 指向当前的i,然后依次和j前的元素进行比较j最小取1.因为i从1开始的。
            for(int j = i; j > 0 && arr[j] < arr[j-1]; j--){
                    Swap.swap(arr,j,j-1);

            }
        }
    }
    public static void insertionSort_2(int[] arr){
        for(int i = 1; i < arr.length; i++){

            //j的物理意义：j指向i的前一个数，则j+1就代表i，依次进行比较
            for(int j = i-1; j >=0 && arr[j] > arr[j+1]; j--){
                Swap.swap(arr,j,j+1);
            }
        }
    }

    //优化版本,找到该插入的位置，避免一直交换
    public static void insertionSort_3(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int tmp = arr[i];
            int j;
            for( j = i; j > 0 && arr[j - 1] > tmp; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
    }
    public static void insertionSort_4(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int tmp =arr[i];
            int j;
            for(j = i-1; j >=0 && arr[j] > tmp; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = tmp;
        }
    }

    //在[l..r]上进行插入排序
    public static void insertionSort_5(int[] arr,int l,int r){
        for(int i = l+1; i <= r; i++){
            int tmp = arr[i];
            int j;
            for(j = i; j > l && arr[j - 1] > tmp; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
        return;
    }


}
