package www.test.java;

/**
 * TOPK问题
 * 在数组中寻找第K大的数
 */
public class TOPK {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,6,7,3,5,9,0,8};
        int ret = TopK(arr,0,arr.length - 1,4);
        System.out.println(ret);
    }
    //在[l..R]上找第K大的数
    public static int TopK(int[] arr,int L,int R,int k){

        int ret = partition(arr, L, R);
        //System.out.println();
        if (ret == k - 1) {
            return arr[ret];  // ****不能返回ret[k].因为下标
        } else if (ret > k - 1) {
            return TopK(arr, L, ret - 1, k);
        } else {    // ret[0[ + 1 < k
            return TopK(arr, ret + 1, R, k - ret);
        }
    }
    public static int partition(int[] arr,int L,int R){
        int less = L - 1;
        int more = R + 1;
        int num = arr[R];    // 需要将作为划分值的元素保存起来，因为交换操作会更改该值
        while(L < more) {
            if(arr[L] > num){
                swap(arr,--more,L);
            }else{
                L++;
                less++;
            }
        }
        return less ;

    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
