package com.github.excellent01;

import java.util.Arrays;

/**
 * @auther plg
 * @date 2019/5/19 17:22
 */
public class ArrayStack<T> extends AbstractMyStack <T> {
    private Object[] element;
    public ArrayStack(int maxsize) {
        super(maxsize);
        element = new Object[maxsize];
    }

    @Override
    public boolean push(T t) {
        if(this.count == this.size){
           element = Arrays.copyOf(element,this.size * 2 < (Integer.MAX_VALUE - 8) ? this.size * 2 : Integer.MAX_VALUE - 8);
        }
        element[count++] = t;
        return true;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new RuntimeException("栈为null");
        }
        return (T) element[--count];
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("栈为null");
        }
        return (T) element[count-1];
    }
}
