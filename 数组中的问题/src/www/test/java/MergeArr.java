package www.test.java;

public class MergeArr {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,5,6};
        int[] arr2 = {2,4,5,7,9,10,12};
        int[] arr = mergeArr(arr1,arr2);
        for(int data : arr){
            System.out.print(data + "、");
        }
    }
    public static int[] mergeArr(int[] arr1,int[] arr2){
        if(arr1 == null && arr2 == null){
            throw new RuntimeException("数组不合法");
        }
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < arr1.length  && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                arr[k++] = arr1[i++];
            }else {
                arr[k++] = arr2[j++];
            }
        }
        while(i < arr1.length ){
            arr[k++] = arr1[i++];
        }
        while(j < arr2.length ){
            arr[k++] = arr2[j++];
        }
        return arr;
    }
}
