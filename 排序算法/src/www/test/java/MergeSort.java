package www.test.java;

public class MergeSort {
    //     自顶向下进行归并排序

    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr,0,arr.length - 1);
    }
    public static void mergeSort(int[] arr,int l,int r){
//        if(l >= r){
//            return;
//        }
        //  优化2：  当数据规模较小时采取插入排序。（常数系数比较小）
        if(r - l < 15){
            InsertionSort.insertionSort_5(arr,l,r);
            return;
        }
        int mid = l + ((r - l) >> 1);
        //int mid = (l + r) / 2;
        mergeSort(arr, l,mid);
        mergeSort(arr,mid+1,r);

        //优化①,当arr[mid] < arr[mid+1]的时候无需归并L，已经有序
        if(arr[mid] >= arr[mid+1])
        merge(arr,l,mid,r);
    }

    //在[l...mid]和[mid+1...r]上两部分进行归并
    public static void merge(int[] arr,int l,int mid,int r){
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= r ){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }

        //归并后的数组内容拷贝回原数组
        for(i = 0; i < help.length; i++){

            //两者间有个 L 的偏移量
            arr[i+l] = help[i];
        }

    }

    public static void mergeSOrtBU(int[] arr){
        for(int sz = 1; sz < arr.length; sz *= 2){
            for(int i = 0; i + sz < arr.length; i += 2*sz){
                merge(arr,i,i + sz - 1,Math.min(i + sz + sz - 1,arr.length - 1));
            }
        }
    }
    /**
     *  public static void merge(int[] arr,int L, int mid, int R){
     *         int[] help = new int[R - L + 1]; //辅助数组
     *         int i = 0;
     *         int p1 = L;
     *         int p2 = mid + 1;
     *         while(p1 <= mid && p2 <= R ){ //该循环结束必有一个越界，不存在同时越界
     *             help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];//太巧了
     *         }
     *         while(p1 <= mid){
     *             help[i++] = arr[p1++];
     *         }
     *         while(p2 <= R ){
     *             help[i++] = arr[p2++];
     *         }
     *        for(i = 0; i < help.length; i++){
     *             arr[L + i] = help[i];
     *        }
     */
}

