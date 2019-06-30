package Day16;

import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/6/4 15:20
 */
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int m = in.nextInt();
            System.out.println(getSequenceOdd(m));
        }
    }
    public static String getSequenceOdd(int m){
        if(m == 1){
            return "" + 1;
        }
        int num = m * m * m;
        int n = m * m - (m - 1);
        String str = "";
        for(int i = n; n < num; i += 2){
            n += i;
            str += (i + "+");
        }
        return str.substring(0,str.length() - 1);
    }
}
