package www.test.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @auther plg
 * @date 2019/3/29 22:41
 */
class Cat{
    private String hue;
    private Cat(){}

    public Cat(String hue) {
        this.hue = hue;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "hue='" + hue + '\'' +
                '}';
    }
}
class Animal{
    private String name;

    Animal(String name) {
        this.name = name;
    }
    public Animal(){}

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class ConstructorTest {
    public static void main(String[] args) {
        Class cls = Cat.class;
        try {
            // 获取类中指定参数的构造方法，方法参数Class类型,不能取得私有的
            Constructor c1 = cls.getConstructor(String.class);
            try {
                Cat cat = (Cat) c1.newInstance("咪咪");
                System.out.println(cat);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Constructor[] arr = cls.getConstructors();
       for(Constructor c : arr){
           System.out.println(c.getName());
       }


    }
}
