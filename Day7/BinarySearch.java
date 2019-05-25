package Day5;

/**
 * 没有bug的二分查找
 * @auther plg
 * @date 2019/5/24 23:40
 */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binnarySearch(new int[]{1,2,3,4,5,6,7,8,9},8));
    }
    public  static int binnarySearch(int[] arr,int target){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        while(l <= r){
            int mid = l + ((r - l) >> 1);
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
