import java.util.Arrays;
public class Arr
{
    public static void main(String[] args) 
    {
        int[] arr1 = new int[]{1,2,5,8,10};
        int[] arr2 = new int[]{6,7,8,9,10};
        // System.arraycopy(arr2, 0, arr1, 0, arr2.length-1);
        //实现数组拷贝
        // printArray(arr1);
        // int[] arr3 =  Arrays.copyOf(arr2,10);
        // 实现数组扩容，有返回值直接赋给一个新数组即可！
        // printArray(arr3);
        // Arrays.sort(arr1);
        // 实现数组排序
        // printArray(arr1);
        // Arrays.fill(arr1,0,5,1);
        //数组填充 左闭右开
        // printArray(arr1);
       //System.out.println(Arrays.binarySearch(arr1,100));
       // 在数组中查找指定元素   

    }
    public static void printArray(int[] arr)
    {
        for(int i:arr)
        {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}