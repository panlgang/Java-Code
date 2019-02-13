package www.test.java;

import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 *     对一个数十进制表示时的每一位数字乘五次方再求和，会得到一个数的五次方数
 * 　　例如：1024的五次方数为1+0+32+1024=1057
 * 　　有这样一些神奇的数，它的五次方数就是它自己，而且这样的数竟然只有有限多个
 * 　　从小到大输出所有这样的数
 */
public class FIvePowerNumber {
    public static void main(String[] args){
            for(int i = 0;i < 100000000;i++){
                int num = i;
                int sum = 0;
                while(num > 0){
                    sum += Math.pow(num%10,5);
                    num /= 10;
                }
                if(sum == i){
                    System.out.println(sum);
                }
            }
        }
}
