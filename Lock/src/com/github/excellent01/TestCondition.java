package com.github.excellent01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 练习Condition接口
 * await方法：阻塞当前线程，释放锁
 * signal方法：唤醒当前线程，需要获得锁。
 * @auther plg
 * @date 2019/5/3 16:52
 */
public class TestCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try{
            lock.lock();
            System.out.println("Thread is blocked...");
            condition.await();
            System.out.println("Thread is going on...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        TestCondition test = new TestCondition();
        Thread thread = new Thread(test);
        thread.start();
        Thread.sleep(200);
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
