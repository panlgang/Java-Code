package www.test.java;

/**
 * 数组a[N]中存入1 -- N - 1这N - 1 个数，有一个是重复的，找出该重复的数
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,5,4,3,6};
        int ret = findDup_3(arr);
        System.out.println(ret);

    }

    /**
     * 对数组中的所有元素求和，减去1--N-1的和
     * @param arr
     * @return
     */
    public static int findDup_1(int[] arr) {
        int tmp1 = 0;
        int tmp2 = 0;
        int i = 0;
        for (i = 0; i < arr.length - 1; i++) {
            tmp1 += (i + 1);
            tmp2 += arr[i];
        }
        tmp2 += arr[i];
        return tmp2 - tmp1;
    }

    /**
     * 异或法
     * 用1-- N -1 分别与原数组中的元素进行异或
     * 不同为1，相同为0
     * 0与任何数异或得任何数
     * @param arr
     * @return
     */
    public static int findDup_2(int[] arr){
        int tmp1 = arr[0];
        int tmp2 = 1;
        for(int i = 1; i < arr.length; i++){
           tmp1 ^= arr[i];
        }
        for(int i = 2; i < arr.length; i++){
            tmp2 ^= i;
        }
        return tmp1 ^ tmp2;
    }

    /**
     * 申请辅助空间
     * @param arr
     * @return
     */
    public static int findDup_3(int[] arr){
       int[] help = new int[arr.length];
       for(int i = 0; i < arr.length; i++){
           help[arr[i]]++;
       }
       int ret = 0;
       for(int i = 0; i < help.length; i++){
           if(help[i] == 2){
               ret = i;
           }
       }
       return ret;
    }

}
