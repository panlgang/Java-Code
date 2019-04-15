package com.test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @auther plg
 * @date 2019/4/15 20:57
 */
public class TestSet {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(4);
        set.add(2);
        set.add(3);
        set.contains(3);
        System.out.println(set.add(2));
        System.out.println(set);
    }
}
/**
 * HashSet集合，add元素时可以为null，但不能重复
 * 当为null时直接放在0号桶
 * add  hashCode ----》 equals
 *    先算hashcode，再计算桶下标
 *     --- 位置为null，直接存放
 *     --- 不为null，hash碰撞，判断equals方法
 *         -- 相等 ， 后者取代前者
 *         -- 不想等，连接在后面。
 */
//*******************************************************
/**
 *
 *  TreeSet  底层 TreeMap
 *  不允许为null，if (key == null)
 *                 throw new NullPointerException();
 *  不允许重复Set集合都不允许重复
 *  根据比较器定义排序，根据compareTo方法，判断是否存在
 */
