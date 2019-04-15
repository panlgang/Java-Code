package com.github.excellent01;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @auther plg
 * @date 2019/4/15 16:37
 */
public class Test {
    public static void main(String[] args) {
        MyHashMap<String,Integer> mhm = new MyHashMap<>();
        mhm.put("Tom",20);
        mhm.put("Jack",18);
        mhm.put("Lucy",17);
        mhm.setValue("Tom",19);
        System.out.println(mhm.get("Tom"));
        Set<String> set = mhm.mykeySet();
        for(String str : set){
            System.out.println(str + "====" +  mhm.get(str));
        }
        Collection<Integer> collection = mhm.values();
        for(Integer i : collection){
            System.out.println(i);
        }
    }
}
