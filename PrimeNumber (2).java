public class PrimeNumber
{
    public static void main(String[] args)
    {
        printPrimeNumber2(100);
    }
    // public static void printPrimeNumber1(int num)
    // {
    //    flag: for(int i = 2; i < num; i++)
    //     {
    //         for(int j = 2; j <= Math.sqrt(i); j++)
    //         {
    //             if(i%j == 0)
    //             {
    //                 continue flag;
    //             }
    //         }
    //         System.out.print(i+" ");
    //     }
    // }

    public static void printPrimeNumber2(int num)
    {
        for(int i = 2; i < num; i++)
        {
            boolean flag = false; //每一次进入循环值都必须是false。
            for(int j = 2; j <= Math.sqrt(i); j++)
            {
                if(i%j == 0)
                {
                    flag = true;//不是素数设置flag为true。
                    break;
                }
            }
            if(!flag)
            {
                System.out.print(i+" ");
            }
        }
    }

   
}