package com;

/**
 * 两个线程交替输出1--100
 * @auther plg
 * @date 2019/5/12 22:05
 */
public class Print implements Runnable {
    private int num = 1;
    @Override
    public void run() {
        synchronized (this){
            while(true){
                this.notify();
                if(num <= 100){
                    System.out.println(Thread.currentThread().getName() + " == " + num);
                    num++;
                }else{
                    break;
                }
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        Print print = new Print();
        Thread thread1 = new Thread(print,"A");
        Thread thread2 = new Thread(print,"B");
        thread1.start();
        thread2.start();
    }
}
