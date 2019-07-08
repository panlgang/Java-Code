package Day26;

/**
 * 剑指offer31：； 连续子数组的最大和
 * @auther plg
 * @date 2019/7/6 18:40
 */
public class MaxSumSubArr {
    public static void main(String[] args) {
        int[] arr = new int[]{1,-2,3,10,-4,7,2,-5};
        System.out.println(maxSumSubArr(arr));
    }
    public static int maxSumSubArr(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            result = Math.max(sum,result);
            sum += arr[i];
            if(sum < 0){
                sum = 0;
            }
        }
        return result;
    }
}
