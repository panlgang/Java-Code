package Day8;

/**
 * 一个数组中任选几个数若加起来能达到aim
 * 返回true，否则返回false。
 * @auther plg
 * @date 2019/5/26 23:00
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,7,13};
        System.out.println(process(arr,0,arr.length - 1,9));
    }

    private static boolean process(int[] arr, int l, int r, int aim) {
        if(l == r){
            return aim == arr[r];
        }
        return process(arr,l+1,r,aim - arr[l]);

    }
}
