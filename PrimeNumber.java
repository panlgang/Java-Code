public class PrimeNumber
{
    public static void main(String[] args)
    {
        for(int i = 2; i < 100; i++)
        {
            boolean flag = false; //每一次进入循环值都必须是false。
            for(int j = 2; j < i; j++)
            {
                if(i%j == 0)
                {
                    flag = true;//不是素数设置flag为true。
                }
            }
            if(!flag)
            {
                System.out.print(i+" ");
            }
        }
    }
}