package Day5;

/**
 * 打印字符串的所有子序列
 * @auther plg
 * @date 2019/5/24 22:53
 */
public class PrintStringSub {
    public static void main(String[] args) {
        printSubs("abc");
    }
    public static void printSubs(String str){
        printSubs(str.toCharArray(),0,"");
    }

    /**
     *
     * @param arr  整个字符串所化的数组
     * @param i  具体的某一层
     * @param res 到该层时的结果
     */
    private static void printSubs(char[] arr, int i, String res) {
        if(arr.length == i){
            System.out.println(res);
            return;
        }
        // 不要第i个字符，传给下一级
        printSubs(arr,i+1,res);
        // 要第i个字符传给下一级
        printSubs(arr,i+1,res + String.valueOf(arr[i]));
    }
}
