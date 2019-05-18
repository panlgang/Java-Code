package com.github.excellent01;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 * @auther plg
 * @date 2019/5/18 9:34
 */
public class TwoStackAchieveQueue<E> {
    private Stack<E> pushStack = new Stack<>();
    private Stack<E> popStack = new Stack<>();
    private int size = 0;
    public void push(E e){
        pushStack.push(e);
        size++;
    }
    public E pop(){
        while(!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
        size--;
        return popStack.pop();
    }
    public E peek(){
        while(!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }
    public boolean isempty(){
        return this.size == 0;
    }

    public static void main(String[] args) {
        TwoStackAchieveQueue<Integer> tq = new TwoStackAchieveQueue();
        tq.push(1);
        tq.push(2);
        tq.push(3);
        tq.push(4);
        tq.push(5);
        System.out.println(tq.peek());
        while(!tq.isempty()){
            System.out.println(tq.pop());
        }
    }
}
