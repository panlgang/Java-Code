package com.xust.Singleton;

/**
 * @auther plg
 * @date 2019/7/17 17:08
 */
public class StaticInnerClassSingleton {
    private static class InnerClass{
        private static StaticInnerClassSingleton instance =  new StaticInnerClassSingleton();
    }
    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.instance;
    }
    private StaticInnerClassSingleton(){}
}
