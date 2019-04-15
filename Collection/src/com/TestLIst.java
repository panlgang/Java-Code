package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther plg
 * @date 2019/4/15 20:42
 */
public class TestLIst {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        // add(E e)  -- >  elementData[size++] = e;
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(null);
        // remove,contains  依据equals方法来判断，与hashCode方法无关
        //只会删除一个，即最先出现的
        list.remove(2);
        System.out.println(list);
    }
}
