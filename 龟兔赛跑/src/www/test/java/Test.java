package www.test.java;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int v1  = input.nextInt();
        int v2 = input.nextInt();
        int t = input.nextInt();
        int s = input.nextInt();
        int l = input.nextInt();
        int i = 0;
        int s1 = 0;
        int s2 = 0;
        while(s1 < l && s2 < l){
            i++;
            s1 += v1;
            s2 += v2;
            if(s1 - s2 >= t){
                s1 -= v1 * s;
            }
            if(s1 == l || s2 == l){
                break;
            }
        }
        if(s1 > s2 ){
            System.out.println("R");
        }else if(s2 > s1){
            System.out.println("T");
        }else{
            System.out.println("D");
        }
        System.out.println(i);
    }
}
