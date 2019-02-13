package www.test.java;

import java.util.Scanner;

/**
 * 　输入一个自然数n，求小于等于n的素数之和
 */
public class GetPrimeSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int sum = 0;
        for(int i = 2; i <= num; i++){
            if(isPrime(i)== true){
                sum += i;
            }
        }
        System.out.println(sum);
    }
    public static boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num %i == 0)
                return false;
        }
        return true;
    }


}
