package www.test.java;

/**
 * @auther plg
 * @date 2019/3/27 19:15
 */
public class MergeArrIII {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2,4,5,6,8};
        int[] arr2 = new int[]{2,4,5,7,9};
        mergeArrIII(arr1,arr2);
        printArr(arr1);
        printArr(arr2);
    }
    public static void mergeArrIII(int[] arr1,int[] arr2){
        int len = arr1.length - 1;
        if(arr1[0] >= arr2[len] || arr1[len] <= arr2[0]){
            return;
        }
        int i = 0;
        int j = len;
        if(arr1[0] <= arr2[0]){
            while(j >= 0 && i <= len){
                if(arr1[j] > arr2[i]){
                    swap(arr1,arr2,j--,i++);
                }else{
                    break;
                }
            }
            reverse(arr1,j,len);
            reverse(arr2,0,i);

        }else{
            while(j >= 0 && i <= len){
                if(arr2[j] > arr1[i]){
                    swap(arr1,arr2,j--,i++);
                }else{
                    break;
                }
            }
            reverse(arr1,0,i);
            reverse(arr2,j,len);
        }

    }
    public static void swap(int[] arr1,int[] arr2,int i,int j){
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
    public static void reverse(int[] arr,int left,int right){
        while(left <= right){
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
    public static void printArr(int[] arr){
        for(int data : arr){
            System.out.print(data + " ");
        }
        System.out.println();
    }
}
