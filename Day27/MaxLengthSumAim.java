package Day27;

/**
 * 累加和为aim的最长子数组  返回长度
 * @auther plg
 * @date 2019/7/7 21:43
 */
public class MaxLengthSumAim {
    public static void main(String[] args) {
        System.out.println(process(new int[]{3,2,1,5,1,1,1,1,1,1},6));
    }
    public static int process(int[] arr,int aim){
        if(arr == null || arr.length == 0){
            throw new RuntimeException("参数非法");
        }
        int l = 0;
        int r = 0;
        int sum = arr[0];
        int len = Integer.MIN_VALUE;
        while(r < arr.length){
            if(sum == aim){
                len = Math.max(len,r - l + 1);
                sum -= arr[l++];
            }else if(sum > aim){
                sum -= arr[l++];
            }else{
                r++;
                if(r == arr.length){
                    break;
                }else{
                    sum += arr[r];
                }
            }
        }
        return len;
    }
}
