package www.test.java;

public class SecondSmallNumber {
    public static void main(String[] args) {
       // int[] arr = new int[]{1,3,4,5,7,8,9,2};
        //int[] arr = new int[0];
        int[] arr = new int[]{2,1,1};
        int ret = secondSmallNumber(arr);
        System.out.println(ret);
    }
    public static int secondSmallNumber(int[] arr){
        if(arr == null){
            throw new RuntimeException("数组：null");
        }
        if(arr.length == 0){
            throw new RuntimeException("length: 0");
        }
        if(arr.length == 1){
            return arr[0];
        }
        int min = arr[0];
        int min2 = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min2 = min;
                min = arr[i];
            }else if(arr[i] > min){
                if(arr[i] < min2){
                    min2 = arr[i];
                }
            }
        }
        if(min2 == Integer.MAX_VALUE){
            return min;
        }
        return min2;
    }
}
