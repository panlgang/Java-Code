package Day23;

import java.util.stream.Stream;

/**
 * @auther plg
 * @date 2019/7/3 18:00
 */
public class ROrder {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        rOrder(arr);
        for(int data : arr){
            System.out.print(data + "、");
        }
    }
    public static void rOrder(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        int l = 0;
        int r = arr.length - 1;
        while(l < r){
            while((arr[l] & 1) == 1){  // 位运算符优先级很低
                l++;
            }
            while((arr[r] & 1) == 0){
                r--;
            }
            if(l < r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
    }
}
