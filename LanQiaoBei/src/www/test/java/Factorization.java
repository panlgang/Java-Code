package www.test.java;

import java.util.Scanner;

/**
 * 因式分解
 */
public class Factorization {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        factorization(num);
    }
    public static void factorization(int num){
        if(isPrime(num) == true){
            throw new RuntimeException("非合数！！！");
        }
        int i = 2;
        System.out.print(num + "=");
        while(num > i){
            if(num % i == 0){
                System.out.print(i + "*");
                num /= i;
            }else{
                i++;
            }
        }
        System.out.print(num);
    }
    public static boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
