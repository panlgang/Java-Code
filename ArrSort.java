public class ArrSort
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{3,6,-2,4,45,67,789,1,32,43};
        print(arr);
        //selsectArr(arr);
        java.util.Arrays.sort(arr);
        print(arr);
    }
    // public static void bubule(int[] arr)
    // {
    //     boolean flag = true;
    //     for(int i = 0;i < arr.length - 1 && flag;i++)
    //     {    flag = false;
    //         for(int j = 0;j < arr.length-i-1;j++)
    //         {   
    //             if(arr[j]>arr[j+1])
    //             {
    //                 arr[j] ^= arr[j+1];
    //                 arr[j+1] ^= arr[j];
    //                 arr[j] ^= arr[j+1];
    //                 flag = true;
    //             }
    //         }
    //     }
    // }
    public static void selsectArr(int[] arr)
    {
        for(int i = 0;i < arr.length-1; i++)
        {
            int t = i;
            for(int j = i; j < arr.length; j++)
            {
                if(arr[t] > arr[j])
                {
                    t = j;
                }
            }
            if(t != i)
            {
                arr[i] ^= arr[t];
                arr[t] ^= arr[i];
                arr[i] ^= arr[t];
            }
        }
    }

    public static void print(int[] arr)
    {
        for(int i : arr)
        {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}