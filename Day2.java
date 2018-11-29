public class Day2
{
    public static void main(String[] args)
    {
        int line = 9;
        print(line);
    }
    public static void print(int n)
    {
        int i=0;
        int j=0;
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=i;j++)
            {
                System.out.print(i + "*" + j + "=" + i*j + "\t");
            }
            System.out.print("\n");
        }
    }
}