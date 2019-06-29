package Day12;

import java.util.Scanner;

/**
 *
 * @auther plg
 * @date 2019/5/30 15:52
 */
public class FiB {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
       {
            int n = 15;
            int num1 = 0;
            int num2 = 1;
            int num3 = 0;
            while(num2 < n){
                num3 = num1 + num2;
                num1 = num2;
                num2 = num3;
            }
           System.out.println(Math.min(num2 - n,n - num1));

        }
    }


}
