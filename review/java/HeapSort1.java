package www.review.java;

public class HeapSort1 {
    // 条件依旧成立，（下标，左孩子）
    private static void shiftDown(int[] arr,int n,int k){
        while((2 * k + 1) < n){ // 左孩子不越界
            int j = 2 * k + 1;
            if(j + 1 <  n && arr[j+1] > arr[j]){
                j += 1;
            }
            if(arr[k] >= arr[j]){
                break;
            }
            Swap.swap(arr,k,j);
            k = j;
        }
    }

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int n = arr.length;

        //heapify,调整成为大根堆，从第一个非叶子节点开始(n - 1) / 2
        for(int i = (n - 1) / 2; i >=0; i--){
            //依次调整下标为i的元素
            shiftDown(arr,n,i);
        }
        // for O(n) 调整 log(n).
        for(int i = n - 1; i >= 0; i--){
            Swap.swap(arr,0,i);   //头节点和数组最后一个位置的元素交换
            shiftDown(arr,i,0);
        }
    }
}
