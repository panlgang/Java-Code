package www.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auther plg
 * @date 2019/3/29 22:58
 * 反射调用普通方法
 */
class Person{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
class Student extends Person{
    private String school;

    public Student(String name, Integer age, String school) {
        super(name, age);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return super.toString() +  "Student{" +
                "school='" + school + '\'' +
                '}';
    }
}
public class MethodTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class cls = Student.class;
        Student student = new Student("张三",20,"西科大");
        // 取得所有的普通方法,包括（本类，父类，以及Object类）public 权限的方法
        Method[] m1 = cls.getMethods();
//        for(Method m : m1){
//            System.out.println(m.getName());
//        }


        //取得本类的所有普通方法，包括私有方法
        Method[] m2 = cls.getDeclaredMethods();
//        for(Method m : m2){
//            System.out.println(m.getName());
//        }
        // 取的指定参数的构造方法
        Method m3 = cls.getMethod("toString");
        Method m4 = cls.getMethod("setName", String.class);
        Method m5 = cls.getMethod("setAge", Integer.class);
        Method m6 = cls.getMethod("setSchool", String.class);
        // 通过另一种方式调用其中的方法。
        Object obj1 = m4.invoke(student,"李明");
        Object obj2 = m5.invoke(student,21);
        Object obj4 = m6.invoke(student,"北大");
        Object obj3 = m3.invoke(student);
        System.out.println(obj3);




    }
}
