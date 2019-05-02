package com.github.excellent;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 启动线程会被阻塞，flag 从内存读入，会存入寄存器中，下次直接从寄存器取值
 * 因此值一直是false
 * 即使别的线程已经将值更改了，它也不知道
 * 加volatile即可。也可以加锁，只要保证内存可见性即可
 * @auther plg
 * @date 2019/5/2 22:40
 */
public class Testvolatile {
    public static volatile   boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()->{
            for(;;) {
                if (flag == true) {
                    System.out.println("flag == !flag");
                }
            }
        });
        Thread thread2 = new Thread(()->{
            for(;;){
                flag = true;
            }
        });
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }
}
