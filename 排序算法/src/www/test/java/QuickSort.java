package www.test.java;

public class QuickSort {
    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort_2(arr,0,arr.length - 1);
    }

    //********************************************************
    private static void quickSort_1(int[] arr,int L,int R){
        if(L < R){
            int p = partition_1(arr,L,R);
            quickSort_1(arr,L,p-1);
            quickSort_1(arr,p+1,R);
        }
    }
    //  单项调整
    private static int partition_1(int[] arr,int L,int R){
        //将第一个元素作为划分标志
        int i = L + 1;
        int j = L;
        //arr[L+1...j] < arr[L] , arr[j+1..R] > arr[L](等于部分也在里面包括着)
        //当有很多个等于部分时，会退化为O(N*N);
        while(i <= R){
            if(arr[i] < arr[L]){
                Swap.swap(arr,++j,i++);
            }else{
                i++;
            }
        }
        Swap.swap(arr,L,j);
        return j;
    }
    //*********************************************************
    private static void quickSort_2(int[] arr,int L,int R){
        if(L < R){
            int p = partition_2(arr,L,R);
            quickSort_2(arr,L,p-1);
            quickSort_2(arr,p+1,R);
        }
    }
    //双向调整,当数组大部分有序时会退化为O(N*N);
    private static int partition_2(int[] arr,int L,int R){
        int i = L + 1; //从前向后遍历
        int j = R;    //从后向前遍历
        while(true){
            while(i <= R  && arr[i] < arr[L]){
                i++;
            }
            while(j >= L + 1 && arr[j] > arr[L]){
                j--;
            }
            if(i >= j){
                break;
            }else { //将等于部分分到两部分，//arr[L+1...j] <= arr[L] , arr[j+1..R] => arr[L]
                Swap.swap(arr, i, j);
                i++;
                j--;
            }
        }
        Swap.swap(arr,L,j);
        return j;
    }
    //*****************************************************************
    //在[L，R]上进行快速排序
    private static void quickSort(int[] arr,int L,int R){
        if(L >= R){
            return;
        }
        int[] p = partition_3(arr,L,R);
        quickSort(arr,L,p[0]-1);
        quickSort(arr,p[1] + 1,R);
    }

    //随机快速排序，三路调整
    private static int[] partition_3(int[] arr,int L,int R){
        int less = L - 1;
        int more = R;
        //将最后一个数作为划分标志
        Swap.swap(arr,R,L +(int)(Math.random() * (R - L + 1)));
        while(L < more){
            if(arr[L] < arr[R]){
                Swap.swap(arr,++less,L++);
            }else if(arr[L] > arr[R]){
                Swap.swap(arr,--more,L);
            }else{
                L++;
            }
        }
        Swap.swap(arr,R,more);
        return new int[]{less + 1,more + 1};
    }


    private static int[] partition_4(int[] arr,int L,int R){
        int less = L - 1;
        int more = R + 1;
        Swap.swap(arr,R,L + (int) (Math.random()*(R - L + 1)));
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
    //*****************************************************************8
}
