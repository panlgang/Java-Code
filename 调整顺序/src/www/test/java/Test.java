package www.test.java;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        int arr[] = new int[]{1,3,5,7,8,9,2,4};
        //change(arr,0,5);
        reverse(arr,0,4);
        reverse(arr,5,7);
        reverse(arr,0,7);
        for(int data : arr){
            System.out.print(data + " ");
        }
        System.out.println();
    }

    /**
     *
     * @param arr
     * @param L  左边部分的开始下标
     * @param R  右边部分的开始下标
     */
    public static void change(int[] arr,int L,int R){
        int len = arr.length;
        int[] help = new int[len];
        int i = 0;
        int tmp = R;
        while(tmp < len ){
            help[i++] = arr[tmp++];
        }
        while(L < R ){
            help[i++] = arr[L++];
        }
        for(i = 0; i < help.length; i++){
            arr[i] = help[i];
        }
    }
    // 数组逆序
    public static void reverse(int[] arr,int l,int r){
        while(l < r){
            int tmp = 0;
            tmp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = tmp;
        }
    }


}
