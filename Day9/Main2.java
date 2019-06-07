package Day9;

/**
 * 最大公约数 ---- 辗转相除法
 * @auther plg
 * @date 2019/5/27 22:34
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println(process_1(18,24));
        System.out.println(process_2(18,24));
    }
    public static int process_1(int a,int b){
        int max = a > b ? a : b;
        int min = a > b ? b : a;
        if(max % min == 0){
            return min;
        }
        return process_1(min,max % min);
    }
    public static int process_2(int a,int b){
        int max = a > b ? a : b;
        int min = a > b ? b : a;
        int n = max % min;
        while(n != 0){
            max = min;
            min = n;
            n = max % min;
        }
        return min;
    }
}
