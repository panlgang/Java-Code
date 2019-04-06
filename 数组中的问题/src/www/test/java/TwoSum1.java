package www.test.java;

/**
 * 找两个元素的值和为target
 * 返回这两个元素的索引
 * @auther plg
 * @date 2019/4/6 17:01
 */
public class TwoSum1 {
    public static int[] twoSumi(int[] arr,int target){
        if(arr == null || arr.length < 2){
            return new int[0];
        }
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            if(arr[left] + arr[right] == target){
                return new int[]{left,right};
            }else if(arr[left] + arr[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return new int[0];
    }
}
