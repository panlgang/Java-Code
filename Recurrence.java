public class Recurrence
{
    public static void main(String [] args )
    {
        print(9);
    }
    public static void print(int i)
    {
        if(i == 1)
        {
            System.out.println("1*1=1 ");
        }
        else
        {
            print(i - 1);
            for(int j = 1;j <= i; j++ )
            {
                System.out.print(j + "*" + i + "=" + i*j+"\t" );
            }
            System.out.println();
        }
    }
}