package com.github.excellent01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 运行多个线程同时访问：信号量（Semaphore）.
 * @auther plg
 * @date 2019/5/3 17:05
 */
public class TestSemaphore implements Runnable {
    private Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try{
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        TestSemaphore semp = new TestSemaphore();
        ExecutorService exec = Executors.newFixedThreadPool(20);
        for(int i = 0; i < 20; i++){
            exec.submit(semp);
        }
        exec.shutdown();
    }
}
