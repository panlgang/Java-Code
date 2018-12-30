public class TestBinarySearch
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{24,3,10,23,56,45,32,78,119};
        //printArr(arr);
        arrSort(arr);
        //printArr(arr);
        int ret = BinarySearch(arr,0,arr.length-1,32);
        if(ret != -1)
        {
            System.out.println("下标为:" + ret);
        }
        else
        {
            System.out.println("找不到");
        }
    }
    public static void arrSort(int[] arr)
    {
        int i = 0;
        int j = 0;
        int len = arr.length;
        boolean flag = true;
        for(i = 0; i < len - 1 && flag == true; i++)
        {
            flag = false;
            for(j = 0 ;j < len - 1 - i ; j++)
            {
                if(arr[j]>arr[j+1])
                {
                   arr[j]^=arr[j+1];
                   arr[j+1]^=arr[j];
                   arr[j]^=arr[j+1];
                   flag = true;
                }
                
            }

        }
    }
    public static void printArr(int[] arr)
    {
        for(int data : arr)
        {
            System.out.print(data+" ");
        }
        System.out.println();
    }

    public static int BinarySearch(int[] arr,int left,int right,int key)
    {
            
            while (left <= right)
            {
               int mid = left + (right - left) / 2;
                if (arr[mid] > key)
                {
                    right = mid - 1;
                }
                else if (arr[mid] < key)
                {
                    left = mid + 1;
                }
                else
                    return mid;
            }
            return -1;
            }
}