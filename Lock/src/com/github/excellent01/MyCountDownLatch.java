package com.github.excellent01.CountDown;

/**
 * @auther plg
 * @date 2019/5/18 11:43
 */
public class MyCountDownLatch {
    private final int total;
    private int counter = 0;
    public MyCountDownLatch(int total) {
        this.total = total;
    }
    public void down(){
        synchronized (this){
            this.counter++;
            this.notifyAll();
        }
    }
    public void await() throws InterruptedException {
        synchronized (this){
            while(counter != total){
                this.wait();
            }
            return;
        }
    }
    static class Test implements Runnable{
        public static MyCountDownLatch myCountDownLatch  = new MyCountDownLatch(5);
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " ===结束===");
            myCountDownLatch.down();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        for(int i = 0; i < 5; i++){
            new Thread(test).start();
        }
        Test.myCountDownLatch.await();
        System.out.println("准备工作就绪。");
        System.out.println("finish..");
    }
}
