package Day6;

/**
 * 初始化顺序的问题，为静态变量初始化时还是默认值。
 * @auther plg
 * @date 2019/5/25 10:46
 */
public class InitSequence {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        System.out.println(Singleton.count1);
        System.out.println(Singleton.count2);
    }
}
class Singleton{
    public static Singleton singleton = new Singleton();
    public static int count1 = 10;
    public static int count2;
    Singleton(){
//        System.out.println(count1);    0
//        System.out.println(count2);    0
        ++count2;
        ++count1;
    }
    public static Singleton getSingleton(){
        return singleton;
    }
}

/**
 * 考察类的加载流程
 * 首先执行构造方法，为各个变量赋值，赋值完成后再执行直接的赋值操作。
 * 构造方法初始化了一次，接着由于静态的自己还会初始化一次。
 */
