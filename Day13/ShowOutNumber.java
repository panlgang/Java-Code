package Day13;

/**
 * 统计数量
 * @auther plg
 * @date 2019/5/31 13:58
 */
import java.util.*;
public class ShowOutNumber{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        String str = in.nextLine();
        char[] arr1 = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            arr[arr1[i] - 48]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.println(i + ":" + arr[i]);
            }
        }
    }
}
