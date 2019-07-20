package com.xust.proxy.statics;

/**
 * @auther plg
 * @date 2019/7/19 11:37
 */
public class ProxySubject implements ISubject {
    private RealSubject realSubject = null;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    private void before(){
        System.out.println("购买前....");
    }
    public void buyComputer() {
        this.before();
        realSubject.buyComputer();
        this.after();
    }
    private void after(){
        System.out.println("购买后...");
    }
}
