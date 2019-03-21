package www.test.java;

public class MergeArrII {
    /**
     * 时间：2019年3月21日22点12分
     * @param arr1 有序数组后边容量足以容纳arr2的所有元素
     * @param arr2 有序数组
     *             合并两个有序数组
     */
    public static void mergeArr(int[] arr1,int[] arr2,int len1,int len2){
       int index1 = len1 - 1;
       int index2 = len2 - 1;
       int mergeIndex = len1 + len2 - 1;
       while(index1 >= 0 && index2 >= 0){
           if(arr1[index1] >= arr2[index2]){
               arr1[mergeIndex--] = arr1[index1--];
           }else{
               arr1[mergeIndex--] = arr2[index2--];
           }
       }
       while(index2 >= 0){
           arr1[mergeIndex--] = arr1[index2--];
       }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[7];
        arr1[0] = 1;
        arr1[1] = 3;
        arr1[2] = 4;
        int[] arr2 = new int[]{1,2,3,5};
        for(int data : arr1){
            System.out.print(data + " ");
        }
        System.out.println();
        mergeArr(arr1,arr2,3,4);
        for(int data : arr1){
            System.out.print(data + " ");
        }
        System.out.println();
    }
}
