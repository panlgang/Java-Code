package com.test.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @auther plg
 * @date 2019/4/7 20:06
 */
public class TestSet {
    public static void main(String[] args) {
        testHashSet();
        testTreeSet();
    }
    public static void testHashSet(){
        HashSet<String> set = new HashSet<>();
        // 不允许重复，且无序存储
        set.add("hello,bit");
        set.add("hello");
        set.add("C++");
        set.add("java");
        //set.add(null);
        System.out.println(set);
    }
    public static void testTreeSet(){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(0);
        set.add(3);
        set.add(1);
        set.remove(1);
        System.out.println(set);
    }
}
