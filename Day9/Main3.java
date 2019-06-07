package Day9;

import java.util.Scanner;

/**
 * 不要2，放蛋糕问题，网易
 * @auther plg
 * @date 2019/5/27 22:55
 */
public class Main3{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int[][] arr = new int[x][y];
        System.out.println(process(arr));
    }

    /**
     *  (x - a)(x - a) + (y - b)(y - b) == 4
     *  1.(x - a)(x - a) == 4   (y - b)(y - b) == 0
     *  2.(x - a)(x - a) == 0   (y - b)(y - b) == 4
     *
     *  x == a   y - b ==2   ===== 不能放蛋糕
     *  x - a == 2  y == b   ===== 不能放蛋糕
     *
     *  3.(x - a)(x - a) == 1   (y - b)(y - b) == 3  错
     *  4.(x - a)(x - a) == 3   (y - b)(y - b) == 1  错
     *  4.(x - a)(x - a) == 2   (y - b)(y - b) == 2 错
     */
    public static int process(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 0){
                    if(j + 2 < arr[0].length){
                        arr[i][j+2] = 1;
                    }
                    if(i + 2 < arr.length){
                        arr[i+2][j] = 1;
                    }
                }
            }
        }
        return count(arr);
    }
    public static int count(int[][] arr){
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 0){
                    res++;
                }
            }
        }
        return res;
    }
}
