package Day20;

/**
 * @auther plg
 * @date 2019/6/8 18:23
 */
public class Main{
    public static void main(String[] args){
        int num1 = 300;
        int sum = 0;
        for(int i = 0; i < 30; i++){
            sum += Math.pow(2,i);
        }
        System.out.println(num1 + " " + sum);
    }
}