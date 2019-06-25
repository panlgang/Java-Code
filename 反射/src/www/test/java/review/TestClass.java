package review;

/**
 * 获取一个类的Class对象
 * Class对象全局唯一，在JVM进行类加载时创建
 * @auther plg
 * @date 2019/6/25 20:18
 */
public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Class <TestClass> cls1 = TestClass.class;
        Class <TestClass> cls2 = (Class<TestClass>) Class.forName("review.TestClass");
        Class <TestClass> cls3 = (Class<TestClass>) new TestClass().getClass();
        System.out.println(cls1 == cls2);
        System.out.println(cls2 == cls3);
    }
}
