package Day17;

import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/6/5 10:27
 */
public class Add {
    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int num1 = in.nextInt();
//        int num2 = in.nextInt();
        System.out.println(add(3,5));
        System.out.println(add_2(3,5));
    }
    private static int add(int num1,int num2){
       int sum = num1 ^ num2;
       int cin = (num1 & num2) << 1;
       while(cin != 0){
          int temp = sum;
          sum = sum ^ cin;
          cin = (temp & cin) << 1;
       }
       return sum;
    }
    private static int add_2(int num1,int num2){
        if(num2 == 0){
            return num1;
        }
        return add_2(num1 ^ num2,(num1 & num2) << 1);
    }

}
