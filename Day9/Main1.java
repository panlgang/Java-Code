package Day9;

import java.util.Scanner;

/**
 * 求最小公倍数
 * @auther plg
 * @date 2019/5/27 15:05
 */
public class Main1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(process(a,b));
        System.out.println(process_2(a,b));
    }
    public static int process(int a,int b){
        int i = 1;
        for(i = 1; i < a * b; i++){
            if(i % a == 0 && i % b == 0){
                return i;
            }
        }
        return i;
    }
    // A * B = gcd(A,B) * lcm(A,B)
    public static int process_2(int a,int b){
        int temp = Main2.process_1(a,b);   // 获取到最大公约数
        return a * b / temp;
    }
}