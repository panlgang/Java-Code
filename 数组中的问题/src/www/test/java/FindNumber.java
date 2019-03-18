package www.test.java;

/**
 * 有序数组旋转K位找最小值
 */
public class FindNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,2,3};
        System.out.println(findNumber(arr,3));
    }
    public static int findNumber(int[] arr , int k){
        if(arr == null || arr.length < 0 || k < 0){
            throw new RuntimeException("参数不合法 arr" + arr + "k" + k);
        }
        k =  k % arr.length;
        return  arr[arr.length - k];
    }

}
