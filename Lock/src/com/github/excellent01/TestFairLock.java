package com.github.excellent01;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock(true)  :  公平锁，，维护一个有序队列，成本较高。
 * 没有参数默认是false，不公平锁。
 * synchronized 默认非公平锁，性能高一点
 * @auther plg
 * @date 2019/4/28 21:25
 */
public class TestFairLock implements Runnable {
    private ReentrantLock lock = new ReentrantLock(true);
    @Override
    public void run() {
        while(true){
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获取到锁。。。");
                Thread.sleep(500);
            }catch (InterruptedException e){
              e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TestFairLock fairLock = new TestFairLock();
        new Thread(fairLock,"A").start();
        new Thread(fairLock,"B").start();
        new Thread(fairLock,"C").start();
        new Thread(fairLock,"D").start();

    }
}
