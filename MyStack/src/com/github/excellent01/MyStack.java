package com.github.excellent01;

public interface MyStack <T> {
    boolean push(T t);
    T pop();
    T peek();
    int getCount();
    boolean isEmpty();
}
