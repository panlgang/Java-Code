package www.test.java;

/**
 * 连续子序列最大和问题
 */
public class MaxSubseqquenceSum {
    public static void main(String[] args) {
        int[] arr = {-2,11,-4,13,-5,2};
        System.out.println(maxSubseqquenceSum_1(arr));
        System.out.println(maxSubseqquenceSum_2(arr));

    }

    public static int maxSubseqquenceSum_1(int[] arr){
        int sum = 0;
        int ret = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                ret = Math.max(ret,sum);
            }
            sum = 0;
        }
        if(ret == Integer.MIN_VALUE){
            return 0;
        }
        return ret;
    }

    public static int maxSubseqquenceSum_2(int[] arr){
        int ret = Integer.MIN_VALUE;
        int sum = 0;
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum < 0){
                sum = 0;
            }else{  // sum >= 0
                ret = Math.max(ret,sum);
            }
        }
        return ret;

    }

}
