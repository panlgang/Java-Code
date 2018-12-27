interface IUsb 
{
    public static final String name = "i am an USB interface";
    public abstract void print1();
}
interface ISource
{
    public static final String name = "i am a Source interface";
    public abstract void print2();
}
class Flash  implements IUsb ,ISource
{
    public  void print1()
    {
        System.out.println("i am a flash");
    }
    public  void print2()
    {
        System.out.println("i am a flash");
    }
    public void setup()
    {
        System.out.println("驱动安装成功");
    }
    public void work()
    {
        System.out.println("开始工作");
    }
}
class Print implements IUsb ,ISource
{
    public void print1()
    {
        System.out.println("i am a print");
    }
    public void print2()
    {
        System.out.println("i am a print");
    }
    public void setup()
    {
        System.out.println("驱动安装成功");
    }
    public void work()
    {
        System.out.println("开始工作");
    }
}
abstract class Computer 
{
    abstract public void setup();
    abstract public void work();
}
class InterfaceTest 
{
    public static void main(String[] args) 
    {
    //    IUsb usb1 = new Flash();
    //    ISource print = new Print();
    //    usb1 = (IUsb) print;
        // IUsb usb2 = new Flash();
        // IUsb usb3 = new Print();
        // usb2 = usb3;
        IUsb usb3 = new Flash();
        ISource usb4 = (ISource) usb3;
       
       
    }
}