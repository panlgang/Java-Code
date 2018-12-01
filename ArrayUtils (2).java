
public class ArrayUtils
{   
    //找最大值
    public static int arrayMaxElement(int[] data)
    {
        int max=data[0];
        for(int i=1;i<data.length;i++)
        {
            if(max<data[i])
            {
                max=data[i];
            }
        }
        return max;
    }
    // 找最小值
    public static int arrayMinElement(int[] arr)
    {
        int min=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(min>arr[i])
            {
                min=arr[i];
            }
        }
        return min;
    }
    // 求和
    public static int arrayElementSum(int[] arr)
    {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        return sum;
    }
    // 拼接
    public static int[] arrayJoin(int[] a,int[] b)
    {
        int len=a.length+b.length;
        int data[]=new int [len];
        int i=0;
        int j=0;
        for(i=0;i<data.length;i++)
        {
            if(i<a.length)
            {
                 data[i]=a[i];
            }
            else
            {
                data[i]=b[i-a.length];
            } 
        }
        // while((i<len)&&(j<b.length))
        // {
        //     data[i]=b[j];
        //     j++;i++;
        // }
        return data;
    }
    // 截取一部分
    public static int[] arraySub(int []data,int start,int end)
    {
        int len=end-start;
        int []arr=new int[len];
         int i=0;
        while(start<end)
        {
            arr[i]=data[start];
            i++;start++;
            
        }
        return arr;
    }
    // 正序打印
    public static void printArray(int[] data)
    {
        for(int i=0;i<data.length;i++)
        {
            System.out.print(data[i] + "、");
        }
        System.out.println();
    }
    // 逆序打印
    public static void printReverse(int[] data)
    {
        int i=0;
        for(i=data.length-1;i>=0;i--)
        {
            System.out.print(data[i] + "、");
        }
    }
    // 测试
    public static void main(String[]args)
    {
        int[] A=new int[]{1,3,5,7,9};
        int[] B=new int[]{2,4,6,8,0};
        int[] temp=arrayJoin(A,B);
        printArray(temp);
        printReverse(temp);
        // int[] temp=arraySub(A,1,4);
        // for(int arr:temp)
        // {
        //     System.out.println(arr);
        // }
        // int sum1=arrayElementSum(A);
        // int sum2=arrayElementSum(B);
        // System.out.println("sum1="+sum1);
        // System.out.println("sum2="+sum2);
        // int max=arrayMaxElement(A);
        // int min=arrayMinElement(B);
        // System.out.println("max="+max);
        // System.out.println("min="+min);
        // printArray(A);
        // printArray(B);

    }
}
