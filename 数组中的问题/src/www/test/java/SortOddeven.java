package www.test.java;

/**
 * 将一个数组中的奇数，全部置于偶数之前
 * 空间复杂度O（1）
 * 时间复杂度O（n）
 * 类比于快排的partition操作
 */
public class SortOddeven {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        sortOddeven(arr);
        for(int data : arr){
            System.out.print(data + "、");
        }
        System.out.println();

    }
    public static void sortOddeven(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        int ji = 0;
        int ou = arr.length;
        while(ji < ou){
            if((arr[ji] & 1) == 0){
                swap(arr,ji,--ou);
            }else{
                ji++;
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
