public class Reverse
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        System.out.println("Before : Reverse:");
        printArr(arr);
        reverseArr(arr);
        System.out.println("After : Reverse:");
        printArr(arr);
    }
    public static void reverseArr(int[] arr)
    {
        int i = 0;
        for(i = 0; i < arr.length/2; i++)
        {
            arr[i] ^= arr[arr.length-i-1];
            arr[arr.length-i-1] ^= arr[i];
            arr[i] ^= arr[arr.length-i-1];
        }
    }

    public static void printArr(int[] arr)
    {
        for(int i : arr)
        {
            System.out.print(i +" ");
        }
        System.out.println();
    }

}