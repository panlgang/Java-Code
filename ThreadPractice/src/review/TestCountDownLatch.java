package review;

import java.util.concurrent.CountDownLatch;

/**
 * @auther plg
 * @date 2019/7/5 18:26
 */
public class TestCountDownLatch implements Runnable {
    // 闭锁--倒计时器
    static CountDownLatch latch = new CountDownLatch(5);
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "readying...");
        // 计时器减一（一个线程执行完毕）
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        TestCountDownLatch test = new TestCountDownLatch();
        for(int i = 0; i < 5; i++){
            new Thread(test).start();
        }
        // 阻塞，直到所有线程执行完毕
        latch.await();
        System.out.println("Latch!!!");
    }
}
