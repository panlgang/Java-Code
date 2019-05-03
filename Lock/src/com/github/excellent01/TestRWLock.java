package com.github.excellent01;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读操作，线程并行
 * 写操作，线程串行
 *
 *
 * @auther plg
 * @date 2019/5/3 17:13
 */
public class TestRWLock {
    private  Lock lock =  new ReentrantLock();
    private  ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private  Lock readLock = readWriteLock.readLock();
    private  Lock writeLock = readWriteLock.writeLock();
    private int value = 0;
    public int temp = 0;
    public  int handleRead() throws InterruptedException {
        try{
            readLock.lock();
            Thread.sleep(1000);
            //System.out.println(temp++);
            return value;
        }finally {
            readLock.unlock();
        }
    }
    public void handleWrite(int value) throws InterruptedException {
        try{
            writeLock.lock();
            Thread.sleep(1000);
            System.out.println(temp++);
            this.value = value;
        }finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        TestRWLock test = new TestRWLock();

        Runnable write = new Runnable() {
            @Override
            public void run() {
                try {
                    test.handleWrite(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable read  = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(test.handleRead());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for(int i = 0; i < 10; i++){
            new Thread(write).start();
        }
        for(int i = 0; i < 10; i++){
            new Thread(read).start();
        }

    }
}
