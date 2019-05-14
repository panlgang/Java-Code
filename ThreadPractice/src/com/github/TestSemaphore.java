package com.github;

import java.util.concurrent.Semaphore;

/**
 * 练习Semaphore，增强级的Lock或者synchronized
 * 同一时刻多个线程可以访问共享资源。
 * @auther plg
 * @date 2019/5/14 22:08
 */
public class TestSemaphore implements Runnable {
    // true表明公平性，即按照顺序来
    private static final Semaphore SEMA = new Semaphore(5,true);
    @Override
    public void run() {
        try{
            SEMA.acquire();  // 获取锁
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            SEMA.release();
        }
    }

    public static void main(String[] args) {
        TestSemaphore testSemaphore = new TestSemaphore();
        for(int i = 0; i < 20; i++){
            Thread thread = new Thread(testSemaphore);
            thread.start();
        }
    }
}
