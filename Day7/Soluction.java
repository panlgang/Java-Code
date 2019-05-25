package Day6;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
 * @auther plg
 * @date 2019/5/25 11:52
 */
class Solution {
    public int[] twoSum(int[] arr, int target) {
        if(arr == null || arr.length <= 1){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            //⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
            if(map.containsKey(target - arr[i])){
                return new int[]{map.get(target - arr[i]),i};
            }else{
                map.put(arr[i],i);
            }
        }
        return null;
    }
}
