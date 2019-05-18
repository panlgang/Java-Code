package com.github.excellent01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 * @auther plg
 * @date 2019/5/18 9:01
 */
public class TwoQueueAchieveStack {
    private Queue<Integer> dataQueue = new LinkedList<>();
    private Queue<Integer> helpQueue = new LinkedList<>();
    private int size = 0;
    public void push(int num){
        dataQueue.offer(num);
        size++;
    }
//    public int pop(){
//        this.size--;
//       if(helpQueue.isEmpty()){
//           while(dataQueue.size() > 1){
//               helpQueue.offer(dataQueue.poll());
//           }
//           return dataQueue.poll();
//       }else{
//           while(helpQueue.size() > 1){
//               dataQueue.offer(helpQueue.poll());
//           }
//           return helpQueue.poll();
//       }
//    }

    public int pop(){
        while(dataQueue.size() > 1){
            helpQueue.offer(dataQueue.poll());
        }
        int res = dataQueue.poll();
        size--;
        swap();
        return res;
    }
    public int peek(){
        while(dataQueue.size() > 1){
            helpQueue.offer(dataQueue.poll());
        }
        int res = dataQueue.poll();
        helpQueue.offer(res);
        swap();
        return res;
    }
    private void swap(){
        // 交换一下引用
        Queue<Integer> temp = dataQueue;
        dataQueue = helpQueue;
        helpQueue = temp;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }

    public static void main(String[] args) {
        TwoQueueAchieveStack qt = new TwoQueueAchieveStack();
        qt.push(1);
        qt.push(2);
        qt.push(3);
        qt.push(4);
        qt.push(5);
        System.out.println("==" + qt.peek());
        while(!qt.isEmpty()){
            System.out.println( qt.pop());
        }
    }
}
