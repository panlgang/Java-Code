package Day4;

import java.util.Scanner;

/**
 * 递归 -- 》 动态规划，选硬币问题
 * @auther plg
 * @date 2019/5/23 15:15
 */
//public class Main2 {
//    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
//        while(input.hasNext()){
//            int n = input.nextInt();
//            System.out.println(buyApple(n));
//        }
//    }
//    public static int buyApple(int n){
//        int res = Integer.MAX_VALUE;
//        if(n == 0){
//            return 0;
//        }
//        if(n >= 6){
//            res = Math.min(buyApple(n - 6)+ 1,res);
//        }
//        if(n >= 8){
//            res = Math.min(buyApple(n - 8)+ 1,res);
//        }
//        return (res == Integer.MAX_VALUE  ? -1 : res;
//
//    }
//}

/**
 * f[n] = Math.min{(f[n - 6] + 1),f[n - 8] + 1};
 */
public class Main2{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            System.out.println(buyApple(n));
        }
    }
    public static int buyApple(int n){
        int[] arr = new int[]{6,8};
        int[] help = new int[n + 1];  // 0 ... n
        for(int i = 1; i <= n; i++){
            help[i] = Integer.MAX_VALUE;
            for(int j = 0; j < arr.length;j++){
                if(i >= arr[j] && help[i - arr[j]] != Integer.MAX_VALUE && help[i - arr[j]] + 1 < help[i]){
                    help[i] = help[i - arr[j]] + 1;
                }
            }
        }
        return help[n] == Integer.MAX_VALUE ? -1 : help[n];
    }

}
