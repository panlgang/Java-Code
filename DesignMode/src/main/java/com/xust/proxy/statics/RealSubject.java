package com.xust.proxy.statics;

/**
 * @auther plg
 * @date 2019/7/19 11:36
 */
public class RealSubject implements ISubject {
    public void buyComputer() {
        System.out.println("真实对象付钱。");
    }
}
