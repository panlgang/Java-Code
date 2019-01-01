
interface A
{
    double PI = 3.14;
    double area();
}

interface B 
{
    void setColor(String c);
}

interface C extends A, B
{
    void volume();
}

class Cylinder implements C
{
    private Double radius; 
    private Double height;
    private String color; 
    public double area()
    {
        return PI * radius * radius;
    }
    public Cylinder(double radius ,double height)
    {
        this.radius = radius;
        this.height = height;
    }
    public void setColor(String c)
    {
        this.color = c;
    }
    public void volume()
    {
        System.out.println(this.area() * height);
    }

}
// public class Zday4
// {
//     public static void main(String[] args) 
//     {
//         Cylinder c = new Cylinder(2.0 , 3.0);
//         System.out.println(c.area());
//         c.volume();
//     }
// }























// interface Compute 
// {
//     int compute(int n, int m);
// }

// class Add implements Compute
// {
//     public int compute(int n , int m)
//     {
//         return m + n;
//     }
// }

// class Sub implements Compute
// {
//     public int compute(int n , int m)
//     {
//         return n - m;
//     }
// }

// class Multiply implements Compute
// {
//     public int compute(int n , int m)
//     {
//         return m * n;
//     }
// }

// class Div implements Compute
// {
//     public int compute(int n , int m)
//     {
//         return n / m;
//     }
// }
// class UseCompute
// {
//     public void useCom(Compute com, int one, int two)
//     {
//         System.out.println(com.compute(one,two));
//     }
// }
// public class Zday4
// {
//     public static void main(String[] args) 
//     {
//         UseCompute use = new UseCompute();
//         use.useCom(new Add(), 10, 5);
//         use.useCom(new Sub(), 10, 5);
//         use.useCom(new Multiply(), 10, 5);
//         use.useCom(new Div(), 10, 5);

//     }
// }





























// interface InterfaceA
// {
//     String S = "good ";
//     void f();
// }

// abstract class ClassA 
// {
//     abstract void g();
// }

// class ClassB extends ClassA implements InterfaceA 
// {
//     void g() 
//     {
//        System.out.print(S);
//     }

//     public void f() 
//     {
//         System.out.print(" " + S);
//     }
// }

// public class Zday4 {
//     public static void main(String[] args) 
//     {
//         ClassA a = new ClassB();
//         InterfaceA b = new ClassB();
//         a.g();
//         b.f();
//     }
// }