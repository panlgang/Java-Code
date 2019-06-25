package review;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @auther plg
 * @date 2019/6/25 20:28
 */
public class ClassAndConstructure {
    private int num;
    private String str;

    public ClassAndConstructure(int num) {
        this.num = num;
    }
    private ClassAndConstructure(){

    }
    protected ClassAndConstructure(String str){
        this.str = str;
    }
    public ClassAndConstructure(int num,String str){
        this.num = num;
        this.str = str;
    }

    @Override
    public String toString() {
        return "ClassAndConstructure{" +
                "num=" + num +
                ", str='" + str + '\'' +
                '}';
    }

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<ClassAndConstructure> cls = ClassAndConstructure.class;
        // 获取本类中声明过的所有的构造方法
        Constructor[] constructors = cls.getDeclaredConstructors();
        for(Constructor cc : constructors){
            System.out.println(cc);
        }
        // 获取指定参数的构造方法，必须public修饰
        Constructor<?> con = cls.getConstructor(int.class , String.class);
        System.out.println( con.newInstance(10,"hehe"));
        System.out.println(con);
        // int都可以.class?
        System.out.println(int.class == Integer.class);
    }
}
