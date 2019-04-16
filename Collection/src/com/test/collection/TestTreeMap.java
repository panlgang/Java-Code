package com.test.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @auther plg
 * @date 2019/4/8 21:10
 */
public class TestTreeMap {
    public static void main(String[] args) {
        Person p1 = new Person("Jack",20);
        Person p2 = new Person("Tom",20);
        Person p3 = new Person("Danny",18);
        Person p4 = new Person("Alice",16);

        TreeMap<Person,Integer> map = new TreeMap<>();
        map.put(p1,1);
        map.put(p2,2);
        map.put(p3,3);
        Set<Person> set = map.keySet();
        Iterator<Person> iterator = set.iterator();
        while(iterator.hasNext()){
            Person val = iterator.next();
            System.out.println(val + "=" + map.get(val));
        }
    }
}
