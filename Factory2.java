import java.util.Scanner;
interface IComputer 
{
    void print();
}
class AppleComputer implements IComputer
{
    public void print()
    {
        System.out.println("苹果电脑");
    }
}
class LenovoComputer implements IComputer
{
    public void print()
    {
        System.out.println("联想电脑");
    }
}
class ComputerFactory 
{
    public static IComputer fun(String name)
    {
        if(name.equals("Apple"))
        {
            return new AppleComputer();
        }
        else if(name.equals("Lenovo"))
        {
            return new LenovoComputer();
        }
        return null;
    }
}
class Clinet 
{
    public void BuyComputer(IComputer computer)
    {
        System.out.println("买一个"+toString(computer)+"电脑");
    }
    public String toString(IComputer computer)
    {
        return ("[" + computer + "]")   ;
     }
}
public class Factory2
{
    public static void main(String[] args) 
    {
        Clinet clinet = new Clinet();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要买的电脑型号....");
        String type = sc.nextLine();
        clinet.BuyComputer(ComputerFactory .fun(type));  
    }
}