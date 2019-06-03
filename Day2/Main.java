package Day2;

import java.util.Scanner;
/**
 * 喝汽水问题
 * @auther plg
 * @date 2019/5/21 16:30
 */


public class Main {
    /**
     *
     * @param n  空瓶子数目
     * @return   最大的喝的水的数量
     */
    public static int count(int n){
        return n / 2;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            System.out.println(count(n));
        }

    }
}
