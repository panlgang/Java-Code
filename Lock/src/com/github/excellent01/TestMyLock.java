package com.github.excellent01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther plg
 * @date 2019/4/30 15:25
 */
public class TestMyLock implements Runnable {
    private int num = 0;
    private Lock lock = new MyLock();
//    @Override
//    public void run() {
//            try {
//                lock.lock();
//                System.out.println(Thread.currentThread().getName() + "获取到锁。。。");
//                lock.lock();
//                System.out.println(Thread.currentThread().getName() + "再次获取到锁。。。");
//            } finally {
//                lock.unlock();
//                lock.unlock();
//            }
//    }


    @Override
    public void run() {
        for(int i= 0; i <10000; i++){
            try{
                lock.lock();
                num++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestMyLock myLock = new TestMyLock();
        for(int i = 0; i < 3; i++){
            new Thread(myLock).start();
        }
        Thread.sleep(1000);
        System.out.println(myLock.num);
    }
}
