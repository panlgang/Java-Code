package Day28;
/**
 * 剑指offer36 数组中的逆序对
 * @auther plg
 * @date 2019/7/9 22:34
 */
public class Merge {
    public static void main(String[] args) {
        System.out.println(count(new int[]{7,5,6,4}));
    }
    public static int count(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        return mergeProcess(arr,0,arr.length - 1);
    }

    private static int mergeProcess(int[] arr, int l, int r) {
        if(l == r){
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeProcess(arr,l,mid) + mergeProcess(arr,mid+1,r)+ merge(arr,l,mid,r);

    }
    private static int merge(int[] arr,int l,int mid,int r){
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        int[] help = new int[r - l + 1];
        int count = 0;
        while(p1 <= mid && p2 <= r){
            if(arr[p1] <= arr[p2]){
                help[i++] = arr[p1++];
            }else{
                help[i++] = arr[p2++];
                count += (mid - p1 + 1);
            }
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= mid){
            help[p2++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[i+l] = help[i];
        }
        return count;
    }
}
