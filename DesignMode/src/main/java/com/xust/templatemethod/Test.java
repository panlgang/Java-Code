package com.xust.templatemethod;

/**
 * @auther plg
 * @date 2019/7/17 13:39
 */
public class Test {
    public static void main(String[] args) {
        PutFridge p1 = new PutElephant();
        p1.finish();
        PutFridge p2 = new PutOthers();
        p2.finish();
    }
}
