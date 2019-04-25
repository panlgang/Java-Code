package com.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @auther plg
 * @date 2019/4/13 21:53
 */
public class PrintMap {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("Tom",22);
        map.put("Jack",20);
        map.put("Lucy",18);
        System.out.println("toString遍历：");
        System.out.println(map);

        //通过二次取值遍历
        System.out.println("二次取值遍历:");
        for(String key : map.keySet()){
            System.out.printf("%s=%d %c",key,map.get(key),',');
        }
        System.out.println();

        //通过entrySet方法加迭代器遍历
        System.out.println("通过entrySet方法加迭代器遍历:");
        Iterator<Map.Entry<String,Integer>> iterator =  map.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + "，");
        }
        System.out.println();

        //通过增强型for循环遍历
        System.out.println("通过增强型for循环遍历:");
        for(Map.Entry<String,Integer> temp : map.entrySet()){
            System.out.print(temp + "，");
        }
        System.out.println();
        // forEach遍历
        System.out.println("forEach遍历:");
        map.forEach((key,value) -> System.out.print(key + "=" + value + "，"));

/**
 *   entry接口，是Map接口的内部接口
 *   map.entrySet()返回一个Set集合，里面村的是map整体，类型是Map.Entry<String,Integer>
 */






    }
}
