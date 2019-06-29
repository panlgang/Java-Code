package Day15;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/6/3 14:19
 */
public class Mian2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            BigDecimal num1 = new BigDecimal(str1);
            BigDecimal num2 = new BigDecimal(str2);
            System.out.println(num1.add(num2));
        }
    }
}

