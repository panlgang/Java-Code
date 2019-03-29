package www.test.java;

/**
 * @auther plg
 * @date 2019/3/29 22:13
 */
class Person{
}
public class Test {
    public static void main(String[] args) {
        // 取得一个类的Class对象,三种方式
        Class<Person> cls1 = Person.class;
        Class<Person> cls2 = null;
        try {
             cls2 = (Class<Person>) Class.forName("www.test.java.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person per = new Person();
        Class<Person> cls3 = (Class<Person>) per.getClass();
        try {
            Person per1 = cls1.newInstance();
            Person per2 = cls2.newInstance();
            Person per3 = cls3.newInstance();
            System.out.println(per1 == per2);
            System.out.println(per2 == per3);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(cls1.getPackage().getName());
    }

}
