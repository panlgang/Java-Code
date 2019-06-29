package Day15;

import java.util.Scanner;

/**
 * 输出正方形
 * @auther plg
 * @date 2019/6/3 14:07
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            String[] strs = str.split(" ");
            int line = Integer.parseInt(strs[0]);
            char[] arr = strs[1].toCharArray();
            char ch = arr[0];
            process(line, ch);
        }
    }
    public static void process(int line,char ch){
       int num =(int) ((line / 2.0) + 0.5);
       for(int i = 0; i < num; i++){
           if(i == 0 || i == num - 1){
               for(int j = 0; j < line; j++){
                   System.out.print(ch);
               }
           }else{
               System.out.print(ch);
               for(int j = 0; j < line - 2; j++){
                   System.out.print(" ");
               }
               System.out.print(ch);
           }
           System.out.println();
       }

    }
}
