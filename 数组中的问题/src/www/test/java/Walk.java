package Day12;

import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/5/30 15:34
 */
public class Walk {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(walk(2,3));
        }

    }
    public static int walk(int x,int y){
        return walk(1,1,x,y);
    }
    public static int walk(int i,int j,int x,int y){
        if(i == x || j == y){
            return 1;
        }
        return walk(1+1,j,x,y) + walk(i,j+1,x,y);
    }

}
