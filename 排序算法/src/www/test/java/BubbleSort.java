package www.test.java;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            throw new RuntimeException("参数不合法");
        }
        boolean flag = true;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    Swap.swap(arr,j,j+1);
                    flag = false;
                }
            }
            if(flag == true){
                break;
            }
        }
    }
}
