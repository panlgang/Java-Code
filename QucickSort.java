package www.test.java;

public class QucickSort {
    public static void main(String[] args){
        int[] arr = new int[]{5,4,2,3,6,5,7,8};
        quickSort(arr);
        for(int data : arr){
            System.out.print(data + " ");
        }
    }
    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length - 1);
    }
    private static void quickSort(int[] arr,int l,int r){
        if(l > r){
            return;
        }
        int p = partiton2(arr,l,r);
        quickSort(arr,l,p - 1);
        quickSort(arr,p + 1,r);
    }
    // 单项调整
    //[L+1,j] 小于区，[j+1,i]大于等于区
    private static int partition(int[] arr,int l,int r){
        int index = (int)(Math.random()*(r - l + 1) + l);
        swap(arr,index,l);
        int i = l+1;
        int j = l;
        while(i <= r){
            if(arr[i] < arr[l]){
                swap(arr,++j,i++);
            }else{
                i++;
            }
        }
        swap(arr,l,j);
        return j;

    }
    private static int partiton2(int[] arr,int l,int r){
        int i = l+1;
        int j = r;
        while(true){
            int index = (int)(Math.random()*(r - l + 1) + l);
            swap(arr,l,index);
            while(i <= r && arr[i] < arr[l]) i++;
            while(j >= l+1 && arr[j] > arr[l]) j--;
            if(i > j){
                break;
            }
            swap(arr,i++,j--);
        }
        swap(arr,l,j);
        return j;

    }
    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
