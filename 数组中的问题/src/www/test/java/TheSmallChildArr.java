package www.test.java;

/**
 * 给定一个数组找出数组中连续的子数组和大于等于给定数值value的子数组，
 * 返回子数组的长度。
 */
public class TheSmallChildArr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,6,5,4,7,1};
        System.out.println(theSmallChildArr_2(arr,15));
//        System.out.println(theSmallChildArr_1(arr,3));

    }
    public static int theSmallChildArr_1(int[] arr,int value){
        if(arr == null || arr.length == 0){
            throw new RuntimeException("数组不合法");
        }
        int res = arr.length;
        for(int i = 0; i < arr.length; i++){
            int sum = arr[i];
            for(int j = i+1; j < arr.length; j++){
                sum += arr[j];
                if(sum >= value){
                    res = Math.min(res,j - i + 1);
                    break;
                }
            }
        }
        return res;
    }

    public static int theSmallChildArr_2(int[] arr,int value){
        if(arr == null || arr.length == 0){
            throw new RuntimeException("数组不合法");
        }
        int l = 0;
        int r = 0;
        int sum = 0;
        int res = arr.length + 1;
        while(r+1 < arr.length && l < arr.length){
            if(sum < value){
                sum += arr[++r];
            }else{   // sum >= value
                sum -= arr[l++];
            }
            if(sum >= value){
                res = Math.min(res,r - l + 1);
            }
        }
        if(res == arr.length + 1){
            return 0;
        }
        return res;
    }

}
