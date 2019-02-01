package www.test.java;

import java.util.Scanner;

public class TimeConvert {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        try {
            fun(num);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void fun(int n)throws Exception{
        if(n < 0 || n > 86399){
            throw new Exception("输入不合法");
        }
        int h = n / 3600;    //时
        int t = n % 3600;
        int m = t / 60;       //fen
        t = t % 60;
        int s = t;          //秒
        System.out.println(h + ":" + m + ":" +  s);
    }
}
