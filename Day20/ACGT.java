package Day20;

import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/6/8 16:37
 */
public class ACGT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       String str = in.nextLine();
       int len = in.nextInt();
        char[] arr = str.toCharArray();
        int l = 0;
        int r = 0;
        String ret = null;
        double min = 0;
        double num = 0;
        String s = "";
        while(r < str.length()){
           if(s.length() == len){
               num = process(s);
               if(num > min){
                   min = num;
                   ret = s;
               }
               num = 0;
               s = s.substring(++l);
           }else if(s.length() < len){
               if(r == str.length() - 1){
                   break;
               }
               s += arr[r++];
           }else{
               s = s.substring(++l);
           }
        }
        System.out.println(ret);
    }
    public static double process(String str){
        char[] arr = str.toCharArray();
        double count = 0.0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'G' || arr[i] == 'C'){
                count++;
            }
        }
        return count / str.length();
    }
}
