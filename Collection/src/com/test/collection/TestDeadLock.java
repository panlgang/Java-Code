package com;

/**
 * 死锁代码，共享资源的获取成环
 * 死锁的避免和解决
 * 1.按顺序加锁，多个线程都按照同样的锁的获取顺序。
 * 2.获取锁时限，超过时限自动放弃锁
 * 3.死锁检测
 * @auther plg
 * @date 2019/4/26 10:35
 */
public class TestDeadLock {
    static Object obj1 = new Object();
    static Object obj2 = new Object();
    static Object obj3 = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (obj1){
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println("hehe1...");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (obj2){
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj3){
                    System.out.println("haha2。。。");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (obj3){
                synchronized (obj1){
                    System.out.println("haha3。。。");
                }
            }
        }).start();
    }
}


