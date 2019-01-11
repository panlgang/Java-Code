package www.test.java;
import  java.util.Scanner;
public class test {
    public static void main(String[] args) {
       int n = 0;
       Scanner input = new Scanner(System.in);
       System.out.println("输入n:");
       n = input.nextInt();
       System.out.println("和：" + getSum(n));
       System.out.println("乘：" + getFactorial(n));
    }
    public static long getSum(int n){
        int sum = 0;
        for(int i = 0; i <= n; i++){
            sum += i;
        }
        return sum;
    }
    public static long getFactorial(int n){
        long mul = 1;
        for(int i = 2; i <= n; i++){
            mul *= i;
        }
        return mul;
    }
}
