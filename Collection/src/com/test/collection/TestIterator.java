package com.test.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @auther plg
 * @date 2019/4/7 20:22
 */
public class TestIterator {
    public static void main(String[] args) {
//        List<int[]> list = new ArrayList<>();
//        list.add(new int[]{1,2,3});
//        list.add(new int[]{2,3,4});
//        list.add(new int[]{3,4,5});
//        System.out.println(list.toString());
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);
        // 取得Iterator对象
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.equals("a") || str.equals("c")) {
                iterator.remove();
                continue;
            }
            System.out.println(str);
        }

    }
}
