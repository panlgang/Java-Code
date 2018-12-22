class Outer
{
    {
        System.out.println("外部类的构造块");
    }
    static 
    {
        System.out.println("外部类的静态构造块");
    }
    class Inner
    {
        private int num = 10;
        private String str = "hehe";
        {
            System.out.println("内部类的构造块");
        }
    }
    Inner in = new Inner();
    
}
public class Test
{
    public static void main(String[] args) 
    {
        Outer out = new Outer();
    }
}























// class A
// {
//     private int num;
//     public int getNum()
//     {
//         return this.num;
//     }
// }
// class B
// {
//     private String str;
//     public String getStr()
//     {
//         return this.str;
//     }
// }
// class C
// {
//     class InnerClassA extends A
//     {

//     }
//     class InnerClassB extends B
//     {

//     }
//     public void  fun()
//     {
//         System.out.println(new InnerClassA().getNum());
//         System.out.println(new InnerClassB().getStr());
//     }
// }
// public class Test
// {
//     public static void main(String[] args) 
//     {
//         C c = new C();
//         c.fun();
//     }
// }






























// class Outer
// {
//     private String name = "hehe";
//     public void fun1()
//     {
//         Inner in = new Inner(this);
//         in.fun2();
//     }
//     public String getString()
//     {
//         return this.name;
//     }
    
// }
// class Inner
// {
//     public void fun2()
//     {
//         Outer out = new Outer();
//         System.out.println(out.getString());
//     }
// }
// public class Test
// {
//     public static void main(String[] args)
//     {
//        Outer out = new Outer();
//        out.fun1();
//     }
// }