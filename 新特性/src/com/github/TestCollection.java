package com.github;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther plg
 * @date 2019/4/13 17:55
 */

class PrintImpl{
    public static void printList(String str) {
        System.out.println(str);
    }
}
public class TestCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"a","b","c");
        list.forEach(PrintImpl :: printList);
    }
}
