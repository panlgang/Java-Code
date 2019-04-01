package www.test.java;

import java.util.Arrays;

/**
 * @auther plg
 * @date 2019/4/1 20:35
 */
public class TwoSumIII {
    /**
     * 在一个数组中,任选三个元素,求能组成三角形的个数
     * @param arr
     * @return  能组成三角形的个数
     */
    public static int twoSumIII(int[] arr){
        if(arr == null || arr.length < 3){
            return 0;
        }
        int ans = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            int left = 0;
            int right = i - 1;
            while(left < right){
                if(arr[left] + arr[right] > arr[i]){
                    ans += right - left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;

    }
}
