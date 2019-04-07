package com.test.collection;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @auther plg
 * @date 2019/4/7 20:44
 */
public class TestListlterator {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("java");
        list.add("hehe");
        ListIterator<String> listIterator = list.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }
}
