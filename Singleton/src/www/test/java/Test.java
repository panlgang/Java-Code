package www.test.java;

public class Test {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
        Singleton1 instance3 = Singleton1.getInstance1();
        Singleton1 instance4 = Singleton1.getInstance1();
        System.out.println(instance3 == instance4);

    }
}
