package com.test;

import java.util.Iterator;
import java.util.Stack;

/**
 * Java栈的使用练习
 * @auther plg
 * @date 2019/4/16 21:23
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println(stack.peek());
        //System.out.println(stack.pop());   EmptyStackException
//        Iterator<Integer> iterator = stack.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

    }
}

/**
 *push :  向栈中压入元素
 *pop  :  弹出栈顶元素  线程安全
 *peek ： 观察栈顶元素，不弹出sa
 *
 * 当栈中元素全部弹出后，再执行出栈操作或者观察栈顶元素操作，都会EmptyStackException（空栈异常）
 */
