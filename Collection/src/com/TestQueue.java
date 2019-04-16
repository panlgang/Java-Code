package com.test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 队列使用练习
 * @auther plg
 * @date 2019/4/16 21:35
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>() ;
        queue.offer("Tom");
        queue.offer("Jack");
        queue.offer("Lucy");
        queue.offer(null);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        System.out.println(queue.peek());
        PriorityQueue heap = new PriorityQueue();
        heap.offer(1);
        heap.offer(4);
        heap.offer(3);
        heap.offer(2);
        heap.offer(5);
        heap.offer(9);
        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }

    }

}
/**
 * 队列的练习
 * offer  入队
 * poll   出队
 * peek   观察队首元素
 * 当队中没有元素时，peek结果为null，且队中可以入null。
 *
 * PriorityQueue  类：优先级队列，小根堆
 */
