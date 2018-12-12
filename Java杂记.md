## Java杂记

##### 1.深刻理解Java main方法！

```java
public static  void main(String[] args)
```

main方法是Java程序的入口方法，JVM在运行程序时，会先查找main方法。public是权限修饰符，表明任何类或者对象都可以访问这个方法，static表明main方法是一个静态方法，即方法中的代码是存放在静态区的，只要类被加载后既可以通过使用该方法，而不需要实例化对象。直接类名.方法名访问。

JVM启动时必须按照这种特定的方法签名（public  static  void String类型的数组）来查找方法的入口地址！参数名称没有明确要求，但一般都为args！每个类中都可以定义main方法，但与文件名相同的类里面的main方法才是真正的main方法。

```java
class T
{
    public static  void main(String[] args)
    {
        System.out.println("haha");
    }
}

public class Test
{
    public static  void main(String[] args)
    {
        System.out.println("hehe");
    }
}
```

这样的代码是没有问题的。而且public和static没有先后顺序关系，即顺序可以随意。一个Java文件中只有一个类可以被public修饰.

**注：不能用abstract关键字修饰main方法。**

### 2.Java中的构造方法

构造方法是一种特殊的方法，用来在对象实例化时初始化类中的成员变量。

##### 特点：

1 ).构造函数总是伴随着new操作一起使用，不能由程序员 主动调用，只有在创建变量时由系统自动调用。

2）.构造方法不能被继承，因此必须用super关键字显示的调用父类的构造方法。因此也没有可能被覆盖。但在实例化子类对象前会首先实例化父类对象，即首先调用父类的构造方法。

注：当父类的构造方法为无参构造时，系统会默认在子类构造方法中加上super()，但若为有参构造则必须显示调用。

```java
 class A
 {
     private int num1;
     A(int a)
     {
         System.out.println(a);
     }
 }
 class B extends A
 {
    private int num2;
    B()
    {   super(1);//super 语句必须是第一个语句，因此在这个方法中不能再使用this（）调用其他构造方法
        System.out.println("2");
    }
 }
 public class Test
{
    public static  void main(String[] args)
    {
       B b = new B(); 
    }
}
```

3 ).构造方法可以被重载，构造方法没有返回值类型声明。

4）.普通方法名称可以与构造方法同名。

### 3.this 与super的区别

1）this表示当前对象，用来区分对象的成员变量和函数的形参（当一个方法的形参与类的属性名称相同时）

2）super用来访问父类中的方法和成员变量。当子类的方法与父类的方法相同时会出现同名覆盖，因此要访问父类的方法或者属性必须通过super关键字。

**注：在方法中不论使用super还是this关键字都必须是方法中的第一个语句。因此super和this不能同存于同一个方法中！**



