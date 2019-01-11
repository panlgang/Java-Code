package www.test.java;

import java.util.Scanner;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        int n = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要求第几个Fibonacci数：");
        n = input.nextInt();
        long ret = Fibonacci(n);

       // System.out.println("1.第" + n + "个Fibonacci数是：" + ret);
        System.out.println("2.第" + n + "个Fibonacci数是：" + FibonacciR(n));

    }

    /**
     * 迭代法
     * 递归法
     * @param n
     * @return
     */
    public static long Fibonacci(int n){
        if(n <= 2){
            return 1;
        }
        long f1 = 1;
        long f2 = 1;
        long f3 = 0;
        while(n > 2){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
            n--;
        }
        return f3 ;
    }
    
    public static long FibonacciR(int n){
        if( n <= 2){
            return 1;
        }
        return FibonacciR(n - 1) + FibonacciR(n -2);
    }
}
