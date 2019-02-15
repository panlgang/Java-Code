package www.test.java;

import javafx.scene.transform.Scale;

import java.util.Scanner;

public class DigitSeparate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        fun(num);
    }
    public static void fun(int num) {
       if(num > 10){
           fun(num / 10);
       }
        System.out.print(num % 10 + "、");
    }
}
