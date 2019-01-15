package www.test.java;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       int n = input.nextInt();
       int m = input.nextInt();
       char ch = 'A';
       for(int i = 0; i < m; i++){
           for(int j = 0; j < n; j++){
               System.out.print((char)('A' + Math.abs(i-j)));
           }
           System.out.println();
       }
    }
}
/**
 * 样例输出
 * ABCDEFG
 * BABCDEF
 * CBABCDE
 * DCBABCD
 * EDCBABC
 */
