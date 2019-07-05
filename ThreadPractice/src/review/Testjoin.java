package review;

import java.util.concurrent.TimeUnit;

/**
 * @auther plg
 * @date 2019/7/3 9:10
 */
public class Testjoin extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "#" + i);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Testjoin();
        Thread thread2 = new Testjoin();
        thread1.start();   // 线程1启动
        thread2.start();   // 线程2启动
        thread1.join();    // 阻塞主线程
       //虽然thread2.join没有得到执行，但thread2已经启动了，只要有系统调度thread2就会得到执行
        System.out.println("线程1 执行完毕");
        thread2.join();
        System.out.println("线程2 执行完毕");
        System.out.println("结束");
    }
}
