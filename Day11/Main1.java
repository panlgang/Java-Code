package Day11;

/**
 * 阶乘末尾有多少个连续的0
 * @auther plg
 * @date 2019/5/29 15:08
 */


import java.util.Scanner;

/**
 *  n / 5 + n / 25 + n / 125 + n / 625 .....
 *
 *  100!  24 个
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            System.out.println(process(n));
        }
    }

    private static int process(int n) {
        int i = 1;
        int count = 0;
       while(n / Math.pow(5,i) != 0){
           count += n / Math.pow(5,i);
           i++;
       }
       return count;
    }
}
