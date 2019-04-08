package com.test.collection;

import java.util.*;

/**
 * @auther plg
 * @date 2019/4/8 19:58
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Jack",10);
        map.put("Tom",22);
        map.put("Alice",16);
        //map.put(null,null);
        //   利用keySet加迭代器遍历
        {
            Set<String> set = map.keySet();
            Iterator<String> iterator = set.iterator();
            while(iterator.hasNext()){
                String val = iterator.next();
                System.out.println(val + "=" + map.get(val));
            }
        }
        {
            // values()加迭代器遍历
            Collection<Integer> co = map.values();
            Iterator<Integer> iterator = co.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
        {
            Set<Map.Entry<String,Integer>> set = map.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }

        //

    }
}
