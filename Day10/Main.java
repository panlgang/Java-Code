package Day10;

import java.util.Scanner;

/**
 * 约瑟夫环问题，隔三个删除，返回最终剩下的下标
 * @auther plg
 * @date 2019/5/28 18:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = i;
            }
            System.out.println(process(arr));
            System.out.println(getLive(arr.length,3) - 1);
        }
    }

    /**
     * 长度为i报到就删除
     * @param i  长度
     * @param m  每报到m就删除
     * @return
     */
    private static int getLive(int i,int m){
        if(i == 1){
            return i;
        }
        // 老编号 = (新编号 + （m - 1）) % i + 1
        return (getLive(i - 1,m) + m - 1) % i + 1;
    }
    private static int process(int[] arr) {
        int count = 0;
        int i = 0;
        int n = arr.length;
        while(true){
            if(i < arr.length){
                if(arr[i] != -1){
                    count++;
                    if(count == 3){
                        arr[i] = -1;
                        count = 0;
                        n--;
                        if(n == 0){
                            return i;
                        }
                    }
                }
                i++;
            }else{
                i = 0;
            }

        }
    }
}
