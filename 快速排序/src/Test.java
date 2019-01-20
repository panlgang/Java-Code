public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,6,2,4,9,7,8,0};
        quickSort(arr);
        for(int data : arr){
            System.out.print(data);
        }
        System.out.println();
    }
    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length - 1);
    }
    public static void quickSort(int[] arr,int L,int R){
        if(L < R){
            int[] p = partion(arr,L,R);
            quickSort(arr,L,p[0] - 1);
            quickSort(arr,p[1] + 1, R);
        }
    }
    public static int[] partion(int[] arr,int L,int R){
        int less = L - 1;
        int more = R + 1;
       // swap(arr,R,L * (int)(Math.random() * (R - L + 1)));  //[L, R];
        while(L < more){
            if(arr[L] < arr[R]){
                swap(arr, ++less ,L++);
            }else if(arr[L] > arr[R]){
                swap(arr, --more, L);
            }else{
                L++;
            }
        }
        //swap(arr,more,R);
        return new int[]{less + 1,more};
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
