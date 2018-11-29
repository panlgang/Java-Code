public class Bit
{
    public static void main(String [] args)
    {
        int num = 12345;
        while(num>0)
        {
            int r = num % 10;
            System.out.print(r+" ");
            num /= 10;
        }
    }
}
