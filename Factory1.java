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
public class Factory1
{
    public static void main(String[] args) 
    {
        Clinet clinet = new Clinet();
        clinet.BuyComputer(new LenovoComputer());
        clinet.BuyComputer(new AppleComputer());
    }
}