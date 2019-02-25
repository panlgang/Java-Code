package www.test.java;

/**
 * 将一个数组移为K位
 * 12345678
 * 2
 * 78123456
 *
 * 1.全部逆序，2.部分逆序
 */
public class ReverseKbit {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        reverse(arr,2);
        for(int data : arr){
            System.out.print(data + "、");
        }
    }
    public static void reverse(int[] arr,int k){
        if(arr == null || arr.length == 0){
            return;
        }
        k = k % arr.length;
        reverse(arr,0,arr.length - 1);     //整体逆序
        reverse(arr,0,k - 1);              // 局部逆序
        reverse(arr,k,arr.length - 1);          // 局部逆序
    }
    public static void reverse(int[] arr,int left,int right){
        while(left < right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

}
