package www.test.java;

import java.util.Arrays;


/**
 *
 * 数组中两个元素的值大于target的个数
 * @auther plg
 * @date 2019/4/1 19:58
 */
public class TwoSumII {
    public static int twoSumII(int[] arr,int target){
        if(arr == null || arr.length < 1){
            return 0;
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int ans = 0;
        while(left < right){
            if(arr[left] + arr[right] > target){
                ans += right - left + 1;
                right--;
            }else{
                left++;
            }
        }
        return ans;
    }
}
