package www.test.java;

public class Singleton1 {
    private static Singleton1 instance = null;  //懒汉式
    private Singleton1() {
    }
    public static Singleton1 getInstance1(){
        if(instance == null)
        {
            instance = new Singleton1();
        }
        return instance;
    }

}
