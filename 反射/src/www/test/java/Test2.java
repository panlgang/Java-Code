package www.test.java;

/**
 * @auther plg
 * @date 2019/3/29 22:26
 */
interface Imessage{}
interface IMember{}
// 先继承一个类，再实现若干个接口
class Student extends Person implements Imessage,IMember{
}
public class Test2 {
    public static void main(String[] args) {
        Class<Student> cls = Student.class;
        System.out.println(cls.getPackage().getName());
        // 取得父类的Class对象
        Class<?> clsp = cls.getSuperclass();
        Class<?>[] arr = cls.getInterfaces();
        for(Class cls1 : arr){
            System.out.println(cls1.getName());
        }
    }
}
