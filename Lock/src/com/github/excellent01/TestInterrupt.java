package com.github.excellent01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized 死锁之后，只能等待
 * 但lock锁可以响应中断使得死锁终止
 * lockInterruptibly()，该方法在获取锁的过程中能够相应中断，中断到来之前没有获取到锁
 * 抛出异常，释放已获得的锁
 * @auther plg
 * @date 2019/4/28 20:41
 */
public class TestInterrupt implements Runnable {
    public Lock lock1 = new ReentrantLock();
    public Lock lock2 = new ReentrantLock();
    boolean flag = false;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if(!flag){
            lock1.lock();
            try{
                System.out.println("ddddddd");
                Thread.sleep(1000);
                lock2.lockInterruptibly();
                lock2.lock();
                System.out.println("xxxxxxxx");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock1.unlock();
                lock2.unlock();
            }
        }else {
            lock2.lock();
            try {
                Thread.sleep(1000);
                System.out.println("ttttttt");
                lock1.lock();
                System.out.println("mmmmmmmm");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock2.unlock();
                lock1.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestInterrupt tt = new TestInterrupt();
        Thread thread1 = new Thread(tt);
        Thread thread2 = new Thread(tt);
        thread1.start();
        Thread.sleep(500);
        tt.setFlag(true);
        thread2.start();
        Thread.sleep(1000);
        thread1.interrupt();
    }
}
