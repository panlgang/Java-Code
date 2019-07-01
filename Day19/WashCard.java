package Day19;

import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/6/7 16:45
 */
public class WashCard {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();  // 组数
        //System.out.println(t);
        for(int i = 0; i < t; i++){
            int n = in.nextInt();   // 个数的一半
            //System.out.println(n);
            int k = in.nextInt();  //洗牌次数
            //System.out.println(k);
            int[] arr = new int[n * 2];
            for(int j  = 0; j < 2 * n; j++){
                arr[j] = in.nextInt();
            }
            for(int m = 0; m < k; m++){
                process(arr,n);
            }
            String str = "";
            for(int p = 0;p < arr.length; p++){
                str += (arr[p] + " ");
            }
            str = str.substring(0,str.length() - 1);
            System.out.println(str);
        }
    }

    private static void process(int[] arr, int n) {
        int[] ret = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(i < n){
                ret[2 * i] = arr[i];
            }else{
                ret[2 *(i - n) + 1] = arr[i];
            }
        }
        for(int i = 0; i < ret.length; i++){
            arr[i] = ret[i];
        }
    }

}
