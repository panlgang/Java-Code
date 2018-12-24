public class Prime 
{
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        for(int i = 2; i <= 1000; i++)
        {
            boolean flag = false;
            for(int j = 2; j<= Math.sqrt(i); j++)
            {
                if(i % j == 0)
                {
                    flag = true;
                    break;
                }
            }
            if(!flag)
            {
                System.out.println( i + " ");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
     }
}