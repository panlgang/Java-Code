package www.test.java;
import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        int count = 50000000;
        boolean succeed = true;
        while(count > 0){
            int[] arr = emergeArr(10,10);  //产生随机数组
            //print(arr);
            int[] arr2 = copof(arr);     //将随机数组复制到另一个数组
            mergeSort(arr);      //归并排序
           // print(arr);
            Arrays.sort(arr2);     //调用系统提供的方法进行排序
            //print(arr2);
            if(!(isEqual(arr,arr2))){  //排序玩的结果进行比较
                succeed = false;
                break;
            }
            count--;
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");


    }
    public static int[] copof(int[] arr){
        if(arr == null) {
            return null;
        }
        int[] arr1 = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            arr1[i] = arr[i];
        }
        return arr1;
    }
    public static int[] emergeArr(int size,int value){
        int[] arr = new int[(int)((size+1) * Math.random())];
        for(int i = 0; i < arr.length;i++){
            arr[i] = (int)((value + 1) * Math.random());
        }
        return arr;
    }
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        sortProcess(arr,0,arr.length - 1);
    }
    public static void sortProcess(int[] arr, int L, int R){
        if(L == R){
            return;
        }
        int mid = L + ((R - L) >>1);
        sortProcess(arr,L,mid);
        sortProcess(arr,mid + 1,R);
        merge(arr,L,mid,R);     //将排序好的数组填进辅助数组
    }
    public static void merge(int[] arr,int L, int mid, int R){
        int[] help = new int[R - L + 1]; //辅助数组
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= R ){ //该循环结束必有一个越界，不存在同时越界
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];//太巧了
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= R ){
            help[i++] = arr[p2++];
        }
       for(i = 0; i < help.length; i++){
            arr[L + i] = help[i];
       }
    }
    public static boolean isEqual(int[] arr1,int[] arr2){
        if(arr1 == null && arr2 == null){
            return true;
        }
        if(arr1 == null && arr1 != null || arr2 == null && arr1 != null ){
            return false;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0;i < arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    public static void print(int[] arr){
        for(int data : arr){
            System.out.print(data + " ");
        }
        System.out.println();
    }
}
