package www.test.java;

import java.util.Scanner;

/**
 * 算法训练 最长上升子序列
 * 错误！！！
 */
public class MostLengthNumberSn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //String str = input.nextLine();
        int len = MostLengthNumberSn("25378");
        System.out.println(len);
    }
    public static int MostLengthNumberSn(String str){
        char[] arr = str.toCharArray();
        int[] help = new int[arr.length ];
        for(int i = 0; i < arr.length; i++){
            help[i] = arr[i] - '0';
        }
        int count = 1;
        int ret = 0;
        int i = 0;
        while(i + 1 < help.length) {
            while (help[i] < help[i + 1] && i+1 < help.length) {
                count++;
                i++;
            }
            ret = ret > count ? ret : count;
            count = 1;
            i++;
        }
        return ret;
    }
}
