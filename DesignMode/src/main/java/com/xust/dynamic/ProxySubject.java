package com.xust.proxy.dynamic;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther plg
 * @date 2019/7/19 11:50
 */
public class ProxySubject implements InvocationHandler {
    private Object target = null;

    public Object bind(Object target){
        this.target = target;
        Class cls = target.getClass();
        return Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object ret =  method.invoke(this.target,args);
        this.after();
        return ret;
    }
    private void before(){
        System.out.println("真实业务之前。。。。");
    }
    public void after(){
        System.out.println("真实业务之后。。。。");
    }
}
