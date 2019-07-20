package com.xust.proxy.statics;

/**
 * @auther plg
 * @date 2019/7/19 11:39
 */
public class Test {
    public static void main(String[] args) {
        ISubject real = new RealSubject();
        ISubject proxy = new ProxySubject((RealSubject) real);
        proxy.buyComputer();
    }
}
