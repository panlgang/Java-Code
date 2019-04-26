package com.github;

/**
 * @auther plg
 * @date 2019/4/26 22:30
 */
public class TestReentry {
    public static void main(String[] args) {
        new Thread(new Monitor()).start();
    }
}
class Monitor implements  Runnable{

    @Override
    public void run() {
        testA();
    }
    public synchronized void testA(){
        System.out.println("helloA...");
        // 锁的重入
        testB();
    }
    public synchronized void testB(){
        System.out.println("helloB....");
    }
}
