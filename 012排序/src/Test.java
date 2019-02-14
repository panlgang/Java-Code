import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    /**
     * 问题描述：
     * 一个数组中仅有，0，1，2三种元素，对这个数组进行排序
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,0,2,2};
        sort_3(arr);
        for(int data : arr){
            System.out.print(data + "、");
        }
    }
    public static void sort_1(int[] arr){
        Arrays.sort(arr);
    }
    public static void sort_2(int[] arr){
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                zero++;
            }else if(arr[i] == 1){
                one++;
            }else{
                two++;
            }
        }

        for(int i = 0; i < zero; i++){
            arr[i] = 0;
        }
        for(int i = zero; i < one + zero; i++){
            arr[i] = 1;
        }
        for(int i = one + zero; i < one + two + zero; i++){
            arr[i] = 2;
        }
    }
    public static void sort_3(int[] arr){
        partion(arr,0,arr.length - 1);
    }
    public static void partion(int[] arr,int l,int r){
        int less = l - 1;
        int more = r + 1;
        while(l < more){
            if(arr[l] < 1){
                swap(arr,++less,l++);
            }else if(arr[l] > 1){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
