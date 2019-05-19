package com.github.excellent01;

/**
 * @auther plg
 * @date 2019/5/19 17:19
 */
public abstract class AbstractMyStack<T> implements MyStack<T> {
    public int size = 0;
    public int count = 0;
    public AbstractMyStack(){

    }
    public AbstractMyStack(int maxsize) {
        this.size = maxsize;
    }
    public int getCount(){
        return this.count;
    }
    public boolean isEmpty(){
        return count == 0;
    }
}
