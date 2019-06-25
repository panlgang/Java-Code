package review;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auther plg
 * @date 2019/6/25 20:43
 */
public class ClassAndMethod {
    public void fun1(){
        System.out.println("hehe");
    }
    private void fun2(){}
    static void fun3(){}
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class cls = ClassAndMethod.class;
        ClassAndMethod instance = (ClassAndMethod) cls.newInstance();
        // 获得所有普通方法
        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method);
        }
        // 获得指定参数的普通方法 (方法名称，方法参数)
        Method method = cls.getMethod("fun1");
        method.invoke(instance);

    }
}
