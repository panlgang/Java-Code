package com.github.excellent01;

import java.util.LinkedList;

/**
 * @auther plg
 * @date 2019/5/19 17:34
 */
public class LinkStack<T> extends AbstractMyStack<T>  {
    private Node top;
    class Node{
        T t;
        Node next;

        public Node(T t) {
            this.t = t;
        }
    }
    public LinkStack(){
    }
    @Override
    public boolean push(T t) {
       Node node = new Node(t);
       if(top == null){
           top = node;
       }else{
           node.next = top;
           top = node;
       }
       this.count++;
       return true;
    }

    @Override
    public T pop() {
       if(top == null){
           throw new RuntimeException("栈为null");
       }
       T ret = top.t;
       top = top.next;
       this.count--;
       return ret;
    }

    @Override
    public T peek() {
        if(top == null){
            throw new RuntimeException("栈为null");
        }
        T ret = top.t;
        return ret;
    }
}
