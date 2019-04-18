package com;

/**
 * 守护线程练习
 * @auther plg
 * @date 2019/4/18 22:37
 */
public class TestDaemon {
    public static void main(String[] args) throws InterruptedException {
        Mythread2 mythread2 = new Mythread2();
        Thread thread = new Thread(mythread2);
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2000);
        System.out.println("主线程执行完毕！");

    }
}
class Mythread2 implements Runnable{

    @Override
    public void run() {
        while(true){
            try {
                Thread.currentThread().sleep(100);
                System.out.println("我是守护线程，我伴随JVM一同停止工作。。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

/**
 * 当JVM进程中，所有用户线程都执行完毕后，守护线程伴随JVN一同退出
 */
