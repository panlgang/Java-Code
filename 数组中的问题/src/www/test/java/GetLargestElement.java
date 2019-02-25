package www.test.java;

/**
 * 递归实现求一个数组中元素的最大值.
 */
public class GetLargestElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7,4,9,0};
        System.out.println(getLargestElement(arr));
    }
    public static int getLargestElement(int[] arr){
        if(arr == null || arr.length == 0){
            throw new RuntimeException("数组不合法！");
        }
        //return getLargestElement(arr,0,arr.length - 1);
        return getLargestElement_2(arr,0);

    }
    public static int getLargestElement(int[] arr,int L,int R) {
        if(L == R){
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int lMax = getLargestElement(arr,L,mid);
        int rMax = getLargestElement(arr,mid+1,R);
        return Math.max(lMax,rMax);
    }

    public static int getLargestElement_2(int[] arr,int begin) {
        int length = arr.length - 1 - begin;
        if(length == 0){
            return arr[length];
        }
        return Math.max(arr[begin],getLargestElement_2(arr,begin + 1));
    }

}
