package www.review;

import static www.review.java.Swap.swap;

/**
 * @auther plg
 * @date 2019/7/16 19:12
 */
public class BubbleSort {
    public void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        boolean flag = false;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
