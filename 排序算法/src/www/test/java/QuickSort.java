package www.test.java;

public class QuickSort {
    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length - 1);
    }

    //在[L，R]上进行快速排序
    private static void quickSort(int[] arr,int L,int R){
        int[] p = partion(arr,L,R);
        quickSort(arr,L,p[0]);

    }
    private static int[] partion(int[] arr,int L,int R){
        int less = L - 1;
        int more = R + 1;
        Swap.swap(arr,R,(int) (Math.random()*(R - L + 1)));
        while(L < more){
            if(arr[L] < arr[R]){
                Swap.swap(arr,++less,L++);
            }else if(arr[L] > arr[R]){
                Swap.swap(arr,--more,L);
            }else{
                L++;
            }
        }
        return new int[]{less + 1,more - 1};
    }

    /**
     * public static int[] partion(int[] arr,int L,int R){
     *         int less = L - 1;
     *         int more = R + 1;
     *        // swap(arr,R,L * (int)(Math.random() * (R - L + 1)));  //[L, R];
     *         while(L < more){
     *             if(arr[L] < arr[R]){
     *                 swap(arr, ++less ,L++);
     *             }else if(arr[L] > arr[R]){
     *                 swap(arr, --more, L);
     *             }else{
     *                 L++;
     *             }
     *         }
     *         //swap(arr,more,R);
     *         return new int[]{less + 1,more};
     *     }
     */
}
