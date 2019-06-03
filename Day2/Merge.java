package Day2;

/**
 * 逆序对问题
 * @auther plg
 * @date 2019/5/21 18:53
 */
public class Merge {
    public int count(int[]arr, int n) {
        if(arr == null || n == 0){
            return 0;
        }
        return count(arr,0,n-1);
    }
    public int count(int[] arr,int l,int r){
        if(l >= r){
            return 0;
        }
        int mid = (l + r) / 2;
        return merge(arr,l,mid,r) + count(arr,l,mid) + count(arr,mid + 1,r);
    }
    public int  merge (int[] arr,int l,int mid,int r){
        int count = 0;
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while(p1 <= mid && p2 <= r){
            if(arr[p1] <= arr[p2]){
               help[i++] = arr[p1++];
            }else {
                count += (mid - p1 + 1);
                help[i++] = arr[p2++];

            }
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length;i++){
            arr[l+i] = help[i];
        }
        return count;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[]arr = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(merge.count(arr,8));
    }
}
