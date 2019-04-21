package com.github.excellent01;

import java.util.Queue;

/**
 * @auther plg
 * @date 2019/4/21 13:12
 */
public class Consumer implements Runnable {
    private final Queue<Goods> queue;
    private final Integer speed;

    public Consumer(Queue<Goods> queue, Integer speed) {
        this.queue = queue;
        this.speed = speed;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                synchronized (this.queue) {
                    if (!this.queue.isEmpty()) {
                        Goods goods = this.queue.poll();
                        System.out.println(Thread.currentThread().getName() + "将第" + goods.getId() + "号商品售出。。。");
                    } else {
                        System.out.println("队列没有东西了，需要生产！！！");
                        this.queue.notifyAll();
                    }
                }
            }
        }
}
