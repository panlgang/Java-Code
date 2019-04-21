package com;

/**
 * @auther plg
 * @date 2019/4/18 22:08
 */
public class TestSynchronized {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread1);
        thread1.setName("A窗口");
        thread2.setName("B窗口");
        thread1.start();
        thread2.start();
    }
}
class MyThread1 implements Runnable{
    private int sticket = 100;
    @Override
    public  void run() {
        synchronized (this){
            while (sticket > 0) {
                System.out.println(Thread.currentThread().getName() + "将第" + sticket-- + "张票售出");
            }
        }
    }
}
/**
 * 未加锁出现一票多卖的情况,顺序不严格的问题
 *
 * 加锁 ：synchronized
 *     --- 同步代码块  synchronized (this)  锁当前对象
 *                    synchronized (MyThread1.Class)  锁Class对象,全局锁，锁住了整个代码段
 *     --- 同步方法    public synchronized void run()   在方法上加锁
 */
