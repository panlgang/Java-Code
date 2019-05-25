package Day7;

import java.util.Scanner;

/**
 * // 解方程问题
 * @auther plg
 * @date 2019/5/25 20:16
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();  // A-B
        int num2 = in.nextInt();  // b - C
        int num3 = in.nextInt();   // A + B
        int num4 = in.nextInt();   // b + C
        double a = (num1 + num2) / 2.0;
        double b = (num2 + num4) / 2.0;
        double c = (num4 - num2) / 2.0;
        if(a == (int)a && b == (int)b && c == (int)c && a >= 0 && b >= 0 && c >= 0){
            System.out.println(a + " " + b + " " + c);
        }else{
            System.out.println("No");
        }
    }
}
