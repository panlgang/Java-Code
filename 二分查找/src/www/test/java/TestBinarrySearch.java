package www.test.java;

/**
 * 边界问题强化
 */
public class TestBinarrySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(binarySearch_2(arr,5));
        System.out.println(binarySearch_3(arr,0,arr.length-1,0));
    }
    public static int binarySearch_1(int[] arr,int target) {
        if(arr == null || arr.length == 0){
            throw new RuntimeException("数组有问题！");
        }
        int l = 0;
        int r = arr.length - 1;   //在[l...r]范围类进行二分查找,数组元素升序
        while(l <= r){
            int mid = l + ((r - l)>>1);
            if(arr[mid] == target){
                return mid;
            }
            if(target < arr[mid]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
    public static int binarySearch_2(int[] arr,int target){
        if(arr == null || arr.length == 0){
            throw new RuntimeException("数组不合法！");
        }
        int l = 0;
        int r = arr.length;  //在[l...r)范围内进行折半查找
        while(l < r){
            int mid = l + (r - l)>>1;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] > target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch_3(int[] arr,int l,int r,int target){
        if(arr == null || arr.length == 0){
            throw new RuntimeException("数组不合法！");
        }
        if(l < r){
            return -1;
        }
        int mid = l + (r - l)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid] > target){
            return binarySearch_3(arr,l,mid - 1,target);
        }else {
            return binarySearch_3(arr,mid + 1,r,target);
        }
    }
}
