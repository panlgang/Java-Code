package com.github.excellent01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock(时间),在获取锁的过程中，给定时间内未获取到锁，就不等了，退出。
 * 若参数为空，则表明该线程一刻也不愿等待，直接退出。
 * @auther plg
 * @date 2019/4/28 21:11
 */
public class TestTryLock implements Runnable {
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try{
           if( lock.tryLock(1, TimeUnit.SECONDS)) {
               System.out.println(Thread.currentThread().getName() + "获取到锁，进来睡两秒。。。");
               Thread.sleep(2000);
           }else{
               System.out.println(Thread.currentThread().getName() + "不等了，先溜了。。。");
           }
        }catch (InterruptedException e){
            e.printStackTrace();

        } finally{
            // 持有当前锁才有必要释放
            if(lock.isHeldByCurrentThread())
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestTryLock testTryLock = new TestTryLock();
        new Thread(testTryLock).start();
        new Thread(testTryLock).start();
    }
}
