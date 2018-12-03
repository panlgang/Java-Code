public class Foreach
{
    public static void main(String[] args)
    {
        int[] arr1=new int[]{1,2,3,4,5};
        int[][] arr2=new int[][]{{1,2,3},{4,5}};
        int[][][] arr3=new int[][][]{{{1,2,3},{4,5}}};
        printArr(arr1);
        printArr(arr2);
        printArr(arr3);
    }

    // 利用增强型for循环打印一维数组
     public static void printArr(int[] arr)
    {
         for(int i: arr)
         {
            System.out.print(i+" ");
         }
        System.out.println();
    }

    // 利用增强型for循环打印二维数组
    public static void printArr(int[][] arr)
    {
        for(int[] data:arr)
        {
            for(int i: data)
            {
                System.out.print(i+" ");
            }
        }
         System.out.println();
    }


    // 利用增强型for循环打印三维数组
     public static void printArr(int[][][] arr)
     {
         for(int[][]data:arr)
         {
             for(int[]daat:data)
             {
                 for(int i:daat)
                 {
                     System.out.print(i+" ");
                 }
             }
         }
          System.out.println();
     }
    
} 
/**
总结：利用增强型for循环打印多维数组时，还是按照一维数组来处理。
eg：二维数组
首先二维数组的元素都是一维数组，因此循环里面的第一个变量为一维数组类型。
然后嵌套第二个循环打印一维数组中的每一个元素。循环里面第一个变量为整型，
第二个变量为第一个循环里面定义的那个数组。
 */