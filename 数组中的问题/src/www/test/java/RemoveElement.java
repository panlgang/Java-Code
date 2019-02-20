package www.test.java;

/**
 * 给定一个数组和一个数值val，将数组中所有等于val的元素删除。并返回剩余元素的个数。
 * 进阶：1.保持其它元素的相对顺序
 *      2.空间复杂度O（1）.
 *
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = new int[]{7,1,1,2,3,1,5};
        int ret = removeElement(arr,1);
        System.out.println(ret);
        for(int i = 0; i < ret; i++){
            System.out.print(arr[i] + "、");
        }

    }
    public static int removeElement(int[] arr,int value){
        if(arr == null || arr.length == 0){
            throw new RuntimeException("数组不合法！");
        }
        int i = 0;
        int j = 0;
        int count = 0;
       while(i < arr.length && j < arr.length){
          if(arr[i] != value){
              swap(arr,i++,j++);
          }else{
              i++;
              count++;
          }
       }
       return arr.length - count;
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
