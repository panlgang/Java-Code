package com.github.excellent01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther plg
 * @date 2019/4/28 19:28
 */
public class TestLock {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        Thread thread1 = new Thread(mt);
        Thread thread2 = new Thread(mt);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(mt.getNum());
    }
}
class MyThread implements Runnable{
    private int num = 0;
    // 将锁作为一个共有的类的属性。
    private Lock lock = new ReentrantLock();
    @Override
    public  void run() {
        for(int i = 0; i < 10000; i++){
           // Lock lock = new ReentrantLock();  锁不住每个线程都有属于自己的lock锁。
            lock.lock();
            lock.lock();
            try {
                num++;
            }finally{
                lock.unlock();
                lock.unlock();
            }
        }
    }
    public  int getNum() {
        return num;
    }
}

/**
 * 与synchronized相比，lock系列有显示的加锁和解锁过程
 * 灵活性更高
 */
