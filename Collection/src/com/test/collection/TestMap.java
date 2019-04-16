package com.test;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * @auther plg
 * @date 2019/4/15 21:20
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(20,null);
        map.put(10,null);
        System.out.println( map.containsValue(null));
        System.out.println(map);
    }
}
/**
 * HashMap put方法
 * key  value  都可以为null
 *
 * TreeMap pur 方法
 * key 不能为null，value可以为null。
 * containsValue(null)  ✔
 * containsKey(null)
 *
 * Hashtable put方法
 * key,value  都不能为null×
 *
 */
