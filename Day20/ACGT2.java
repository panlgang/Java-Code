package Day20;

import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/6/8 17:57
 */
public class ACGT2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int len = in.nextInt();
        char[] arr = str.toCharArray();
        double min = -1.0;
        String res = "";
        for(int i = 0; i < arr.length; i++){
            StringBuilder ret = new StringBuilder();
            for(int j = i; j < arr.length; j++){
                ret.append(arr[j]);
                if(ret.length() >= len){
                    double rat = process(String.valueOf(ret));
                    if(rat > min){
                        min = rat;
                        res = ret.toString();
                    }
                }
            }
        }
        System.out.println(res);
    }
    public static double process(String str){
        char[] arr = str.toCharArray();
        double count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'G' || arr[i] == 'C'){
                count++;
            }
        }
        return count / str.length();
    }

}
