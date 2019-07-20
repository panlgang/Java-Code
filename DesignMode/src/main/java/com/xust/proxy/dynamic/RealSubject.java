package com.xust.proxy.dynamic;

/**
 * @auther plg
 * @date 2019/7/19 11:54
 */
public class RealSubject implements ISubject {
    public void buy(){
        System.out.println("付钱..");
    }
}
