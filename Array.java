public class Array
{
    public static void main(String[] args)
    {
        int []data=init();
        java.util.Arrays.sort(data);
         printArray(data);
    }
    public static void printArray(int[] data)
    {
        for(int arr:data)
        {
            System.out.print(arr+" ");
        }
    }
    public static int[] init()
    {
        return new int[]{7,2,3,8,5};
    }

}