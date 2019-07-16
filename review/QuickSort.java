package www.review;
import org.junit.Test;
import static www.review.java.Swap.swap;

/**
 * @auther plg
 * @date 2019/7/13 10:05
 */
public class QuickSort {
    public void quicSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quicSort(arr,0,arr.length - 1);
    }

    private void quicSort(int[] arr, int l, int r) {
        if(l >= r){
            return;
        }
        int p[] = partition(arr,l,r);
        quicSort(arr,l,p[0]);
        quicSort(arr,p[1],r);
    }

    private int[] partition(int[] arr, int l, int r) {
        int temp = arr[r];
        int less = l - 1;
        int more = r + 1;
        while(l < more){
            if(arr[l] < temp){
                swap(arr,++less,l++);
            }else if(arr[l] > temp){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        return new int[]{less,more };
    }
    @Test
    public void test(){
        int[]arr = new int[]{1,3,3,2,2,5,5,5,9,0,0,7,7};
        quicSort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
