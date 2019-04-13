package com.test;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 遍历List集合的几种方式
 * @auther plg
 * @date 2019/4/13 21:34
 */
public class PrintLIst {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        Collections.addAll(list,"Java","C++","PHP","Python");
        // toString方法遍历
        System.out.print("toString()======" + list);
        System.out.println();

        //普通for循环遍历
        System.out.print("普通for循环遍历======");
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // 增强型for循环遍历
        System.out.print("增强型for循环遍历======：");
        for(String str : list){
            System.out.print(str + " ");
        }
        System.out.println();

        //迭代器
        Iterator<String> iterator = list.iterator();
        System.out.print("迭代器遍历======");
        while(iterator.hasNext()){

            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // foreach遍历
        System.out.print("方法引用foreach遍历:");
        list.forEach(System.out :: print);
        System.out.println();
        System.out.print("Lambda表达式的foreach遍历:");
        list.forEach(s-> System.out.print(s));
    }
}
