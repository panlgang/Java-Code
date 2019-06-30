package Day16;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @auther plg
 * @date 2019/6/4 14:26
 */
public class SmallNumber{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            System.out.println(process(arr));
        }
    }
    public static String process(int[] arr){
        String str = "";
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < arr[i]; j++){
                str += i;
            }
        }
        int count = arr[0];  // 0 的个数
        String str1 = str.substring(0,count);
        String str2 = str.substring(count + 1);
        return str.charAt(count) + str1 + str2;


    }


}
