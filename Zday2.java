class Fibonacci
{
    private int num;
    public static String county = "China";
    public Fibonacci()
    {
        System.out.print("Hello Constructor ");
    }
    public Fibonacci(int num)
    {
        this();
        this.num = num;
        System.out.println("num="+this.num);
    }
    public int getNum()
    {
        return this.num ;
    }
    public static void fic1(int num)
    {
       int f1 = 1;
       int f2 = 1;
       for(int i = 1; i <= num; i++)
       {   
           int f3 = f1 + f2;
           System.out.print(f1+" ");
           f1 = f2;
           f2 = f3;    
       }
       System.out.println();
    }
    public static int fic2(int num)
    {
        if(num <= 2)
        {
          return 1;            
        }
        return fic2(num-1) + fic2(num-2);

    }

}
public class Zday2
{
    public static void main(String[] args)
    {
       Fibonacci fib = new Fibonacci(10);
       System.out.println("循环输出");
       Fibonacci.fic1(10);
       System.out.println("递归输出");
       int i = 1;
       for(i = 1; i <= fib.getNum(); i++)
       {
           System.out.print( Fibonacci.fic2(i) + " ");
       }
    }
}