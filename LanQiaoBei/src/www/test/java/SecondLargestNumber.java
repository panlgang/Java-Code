package www.test.java;

/**
 * 找数组中的第二大数
 */
public class SecondLargestNumber {
    public static void main(String[] args) {
        //int[] arr = new int[]{1,3,7,5,9,8,9,8};
        int[] arr = new int[]{1,1};
        int ret = secondLargestNumber1(arr);
        System.out.println(ret);
    }

    public static int secondLargestNumber1(int[] arr){
        int max = arr[0];
        int max2 = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]) {
                max = arr[i];
            }
        }
       for(int i = 0; i < arr.length; i++){
            if(arr[i] > max2 && arr[i] != max){
                max2 = arr[i];
            }
       }
       if(max2 != Integer.MIN_VALUE){
           return max2;
       }
       return max;

    }

    /**
     * max存放数组的最大值，ret存次大值
     * * @param arr
     * @return
     */
    public static int secondLargestNumber(int[] arr){
        if(arr == null){
            throw new RuntimeException("数组：null");
        }
        if(arr.length == 0){
            throw new RuntimeException("length: 0");
        }
        if(arr.length == 1){
            return arr[0];
        }
        int max = arr[0];
        int ret = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){    // max变为最大值，ret更新为max
                ret = max;
                max = arr[i];
            }else if(arr[i] < max){  //等于可以进去的话若有多个最大值，输出最大值
                if(arr[i] > ret){      //不包含等于，则会输出第二大值
                    ret = arr[i];
                }
            }
        }
        if(ret != Integer.MIN_VALUE){   //处理异常情况，数组中元素是同一个数
            return ret;
        }
        return max;

    }
}
