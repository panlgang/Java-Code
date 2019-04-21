package com.github.excellent01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 生产者消费者模型练习
 * @auther plg
 * @date 2019/4/21 13:21
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        Queue<Goods> queue = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入生产者数量：");
        int producerNum = input.nextInt();
        System.out.println("请输入生产者速率：");
        int producerSpeed = input.nextInt();
        System.out.println("请输入最大商品个数：");
        int goodsMax = input.nextInt();
        System.out.println("请输入消费者数量：");
        int consumerNum = input.nextInt();
        System.out.println("请输入消费者速率：");
        int consumerSpeed = input.nextInt();
        Producer producer = new Producer(queue,goodsMax,producerSpeed);
        Consumer consumer = new Consumer(queue,consumerSpeed);
        for(int i = 0; i < producerNum; i++){
            new Thread(producer).start();
        }
        Thread.sleep(1000);
        for(int i = 0; i < consumerNum; i++){
            new Thread(consumer).start();
        }





    }
}
