package review;

/**
 * @auther plg
 * @date 2019/6/25 20:24
 */
class A{}
class B extends A{}
public class TestFatherClass {
    public static void main(String[] args) {
        Class cls = B.class.getSuperclass();
        System.out.println(cls.getTypeName());
    }
}
