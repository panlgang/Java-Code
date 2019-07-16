package www.review;


/**
 * @auther plg
 * @date 2019/7/16 19:16
 */
public class MergeSort {
    public void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr,0,arr.length - 1);
    }

    private void mergeSort(int[] arr, int l, int r) {
        int mid = l + ((r - l) >> 1);
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];

        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while(p1 <= mid && p2 <= r){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }
}
