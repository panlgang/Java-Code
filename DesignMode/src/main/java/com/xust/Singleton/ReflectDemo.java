package com.xust.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auther plg
 * @date 2019/7/17 17:36
 */
public class ReflectDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class cls = EnumSingleton .class;
        Constructor constructor = cls.getDeclaredConstructor();
        constructor.setAccessible(true);
        EnumSingleton   l1 = (EnumSingleton  ) constructor.newInstance();
        EnumSingleton   l2 = (EnumSingleton  ) constructor.newInstance();
        System.out.println(l1 == l2);
    }
}
