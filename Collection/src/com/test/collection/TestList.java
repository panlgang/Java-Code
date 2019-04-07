package com.test.collection;

import java.util.*;

/**
 * @auther plg
 * @date 2019/4/7 19:23
 */
public class TestList {
    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
    }
    public static void testLinkedList(){
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list.contains("a"));
        System.out.println(list);
    }
    public static void testArrayList(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(null);
        list.add(null);
//        for(int i = 0; i < list.size(); i++){
//            list.remove(i);
//        }
        System.out.println(list);
    }
}
