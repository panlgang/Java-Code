package com.xust.proxy.dynamic;

/**
 * @auther plg
 * @date 2019/7/19 14:22
 */
public class Test {
    public static void main(String[] args) {
        RealSubject real = new RealSubject();
        ProxySubject proxy = new ProxySubject();
        ISubject obj = (ISubject) proxy.bind(real);
        obj.buy();
    }
}
