package com.github.excellent01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther plg
 * @date 2019/4/21 12:39
 */
public class Producer implements Runnable {
    private final Queue<Goods> queue;
    private final Integer maxNum;
    private final Integer speed;
    private Integer count = 0;

    public Producer(Queue<Goods> queue, Integer maxNum, Integer speed) {
        this.queue = queue;
        this.maxNum = maxNum;
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
                if (this.queue.size() < maxNum) {
                    Goods goods = new Goods(++this.count);
                    queue.offer(goods);
                    System.out.println(Thread.currentThread().getName() + "开始生产第" + goods.getId() + "号产品！！！");
                } else {
                    try {
                        System.out.println("队列满着，不用生产，等待消费。。。。");
                        this.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
