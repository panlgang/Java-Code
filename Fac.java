public class Fac
{
    public static void main(String[] args)
    {
        int num = 20;
        long result1 = fac1(num);
        long result2 = fac2(num);
        System.out.println(result1);
        System.out.println(result2);
    }
    // 循环实现
    public static long fac1(int num)
    {
        long fac = 1;
        while(num>0)
        {
            fac*=num;
            num--;
        }
        return fac;
    }
    // 递归实现
    public static long fac2(int num)
    {
        if(num == 1)
        {
            return 1;
        }
        else
        {
            return num * fac2(num-1);
        }
    }
}