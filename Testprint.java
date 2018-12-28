public class Testprint
{
    public static void main(String[] args) 
    {
        int i = 0;
        int j = 0;
        for(i = 0; i < 8 ; i++)
        {
            for(j = 0; j < 8-i; j++)
            {
                System.out.print(" ");
            }
            for(j = 0; j < 2*i+1; j++)
            {
                System.out.print("*");
            }
            System.out.println(); 
        }
        for(i = 0; i < 7; i++)
        {
            for(j = 0; j < i+2 ;j++)
            {
                System.out.print(" ");
            }
            for(j = 0; j < 13 - 2*i; j++ )
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}