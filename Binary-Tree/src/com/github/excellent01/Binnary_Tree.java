package com.github.excellent01;

public interface Binnary_Tree <E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    boolean modify(E e);
    void preOrder();
    void inOrder();
    void postOrder();
    void leverOrder();

}
