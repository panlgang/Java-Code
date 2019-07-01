package Day19;

import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/6/7 16:23
 */
public class PerNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String N = in.nextLine();

            if(Integer.parseInt(N) == 0){
                return;
            }
            String str = in.nextLine();

            String goal = in.nextLine();

            System.out.println(process(str,Integer.parseInt(goal)));
        }
    }

    private static int process(String str, int goal) {
        int count = 0;
        String[] strs = str.split(" ");
        for(int i = 0; i < strs.length; i++){
            if(goal == Integer.parseInt(strs[i])){
                count++;
            }
        }
        return count;
    }
}
