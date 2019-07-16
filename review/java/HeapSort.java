package www.review.java;

public class HeapSort {
    public static void headSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            heapInsert(arr,i);
        }
        int heapsize = arr.length - 1;
//        while(heapsize > 0){
//            Swap.swap(arr,0,heapsize);
//            heapify(arr,0,heapsize--);  //元素下沉，
//        }
        while(heapsize > 0){
            Swap.swap(arr,0,heapsize);
            heapify(arr,0,heapsize);
            heapsize--;
        }

//        for(int i = arr.length - 1; i > 0; i--){
//            Swap.swap(arr,0,i);
//            heapify(arr,0,i);
//        }
    }

    /**
     * 复杂度分析
     * 形成过程仅与层数有关，因此插入N个元素
     * log1 + log2 + log3 + ... + logN-1 --> O(N)
     * @param arr
     * @param index
     */


    //当前结点比父节点的值大，则进行交换
    //当index为0 时，arr[0]和arr[0]进行比较（循环结束） ---- 精妙之处
    private static void heapInsert(int[] arr,int index){
        while(arr[index] > arr[(index - 1) / 2]){
            Swap.swap(arr,index,(index - 1) / 2);

            //更新index值继续进行while循环
            index = (index - 1) / 2;
        }
    }
    private static void heapify(int[] arr,int index,int size){
        while(2 * index + 1 < size){
            int j = 2 * index + 1;
            if(j + 1 < size && arr[j+1] > arr[j]){
                j += 1;
            }
            if(arr[index] >= arr[j]){
                break;
            }
            Swap.swap(arr,index,j);
            index = j;
        }
    }
}
