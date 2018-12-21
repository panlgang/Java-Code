import java.util.Scanner;
public class Test
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        System.out.println(str);
        input.nextLine();
        double data = input.nextDouble();
        System.out.println(data);
    }
}