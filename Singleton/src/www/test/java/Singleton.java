package www.test.java;

public class Singleton {
    private static Singleton instance = new Singleton();//饿汉式

    private Singleton() {
        System.out.println("无参构造");
    }

    public static Singleton getInstance(){
        return instance;
    }

}
