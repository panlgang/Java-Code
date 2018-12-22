// 1.定义一个Father和Child类，并进行测试。 
// 要求如下： 
// 1）Father类为外部类，类中定义一个私有的String类型的属性name，name的值为“zhangjun”。
// 2）Child类为Father类的内部类，其中定义一个introFather()方法，方法中调用Father类的name属性。 
// 3）定义一个测试类Test，在Test类的main()方法中，创建Child对象，并调用introFather ()方法。 
class Father
{
    private String name = "zhangjun";
    class Child
    {
        public void introFather()
        {
            System.out.println(name);
        }
    }
}
public class Zday3
{
    public static void main(String[] args) 
    {
        Father.Child child = new Father().new Child();
        child.introFather();
        narcissisticNumber();
    }
    public static void narcissisticNumber()
    {
        for(int i = 100; i <= 999 ; i++)
        {
            int num = i;
            int tmp = 0;
            int sum = 0;
            while(num > 0)
            {
                tmp = num % 10;
                num /= 10;
                sum += Math.pow(tmp,3);  
            }
            if(i == sum)
            {
                System.out.print(i+" ");
            }
        }
    }
}

// 定义一个抽象的"Role"类，有姓名，年龄，性别等成员变量 
// 1）要求尽可能隐藏所有变量(能够私有就私有,能够保护就不要公有)， 
// 再通过GetXXX()和SetXXX()方法对各变量进行读写。具有一个抽象的play()方法， 
// 该方法不返回任何值，同时至少定义两个构造方法。Role类中要体现出this的几种用法。 
// 2）从Role类派生出一个"Employee"类，该类具有Role类的所有成员（构造方法除外）， 
// 并扩展salary成员变量，同时增加一个静态成员变量“职工编号（ID）”。 
// 同样要有至少两个构造方法，要体现出this和super的几种用法，还要求覆盖play()方法， 
// 并提供一个final sing()方法。 

// abstract class Role
// {
//     private String name ;
//     private short age;
//     private char sex;
//     public Role()
//     {
//         System.out.println("无参构造");
//     }
//     public Role(String name,short age,char sex)
//     {
//         this.name = name ;
//         this.age = age ;
//         this.age = age ;
//     }

//     public abstract void play();

//     public void setName(String name)
//     {
//         this.name = name ;
//     }
//     public void setAge(short age)
//     {
//         this.age = age ;
//     }
//     public void setSex(char sex)
//     {
//         this.sex = sex ;
//     }
//     public String getName()
//     {
//         return this.name ;
//     }
//     public short getAge()
//     {
//         return this.age ;
//     }
//     public char getsex()
//     {
//         return this.sex ;
//     }
// }
// class Employee extends Role
// {
//     private float salary;
//     private static String id;

//     public Employee()
//     {
//         super();
//         System.out.println("无参构造");
//     }
//     public Employee(float salary)
//     {
//         super();
//         this.salary = salary ;
//     }
//     public void play()
//     {
//         System.out.println("play");
//     }
//     public final void sing()
//     {
//         System.out.println("sing");
//     }
// }
// class Manager extends Employee
// {
//     private final String  vehicle = "奥迪";

// }
// public class Zday3
// {
//   public static void main(String[] args) 
//   {
//       Manager man = new Manager();
//   }
// }

// 3）"Manager"类继承"Employee"类，有一个final成员变量"vehicle" 
// 在main()方法中制造Manager和Employee对象,并测试这些对象的方法。 