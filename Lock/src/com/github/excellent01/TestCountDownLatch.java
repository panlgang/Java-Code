package com.github.excellent01.CountDown;

import java.util.concurrent.CountDownLatch;

/**
 *
 * 倒计时器，CountDownLatch。
 * @auther plg
 * @date 2019/5/14 22:20
 */
public class TestCountDownLatch implements Runnable{
    private static CountDownLatch end = new CountDownLatch(10);
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "完成任务");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestCountDownLatch test = new TestCountDownLatch();
        for(int i = 0; i < 10; i++){
            new Thread(test).start();
        }
        // 只有当指定的的线程执行完成后，才会进行后续操作。
        end.await();
        System.out.println("全部就绪，Fire ！！！");
    }
}
