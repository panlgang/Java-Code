package com.github.excellent01;

/**
 * @auther plg
 * @date 2019/4/14 17:11
 */
public class TestRunnable {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new MyRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();

        //休眠时间，无法确定两个线程执行完毕
        Thread.currentThread().sleep(1);
        System.out.println(((MyRunnable) runnable).getI());

    }
}
class MyRunnable implements Runnable{
    private int i = 0;
    @Override
    public void run() {
        i++;
    }
    public int getI(){
        return i;
    }
}

/**
 * 1.解决单继承局限
 * 2.资源可以实现共享
 * 3.业务逻辑和调度独立，便于维护
 */
