package Day23;

/**
 *
 * 剑指offer 8：旋转数组的最小数字  --- 好题
 * @auther plg
 * @date 2019/7/2 16:13
 */
public class FIndMin {
    public static int findMin(int[] arr){
        if(arr == null || arr.length == 0){
            throw new RuntimeException("参数不合法");
        }
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        int mid = 0;
        if(arr[l] < arr[r]){
            return arr[l];
        }
        if(arr[l] == arr[mid] && arr[mid] == arr[r]){
            return findMinS(arr,l,r);
        }
        while(r != l + 1){
            mid = l + ((r - l) >> 1);
            if(arr[mid] > arr[l]){
                l = mid;
            }else if(arr[mid] < arr[l]){
                r = mid;
            }
        }
        return arr[mid];
    }

    private static int findMinS(int[] arr,int l,int r) {
        int min = arr[l];
        for(; l <= r; l++){
            if(arr[l] < min){
                min = arr[l];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{1,2,3,4,5}));
        System.out.println(findMin(new int[]{5,1,2,3,4}));
        System.out.println(findMin(new int[]{1,1,2,2,1}));
        System.out.println(findMin(new int[]{1,0,1,1,1}));
    }
}
