package com.github;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @auther plg
 * @date 2019/4/13 18:14
 */
public class TestStream {
    public static void code1(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"A","B","C");
        Stream<String> stream = list.stream();
        System.out.println(stream.count());
        stream.filter(e->e.contains("A")).count();
        System.out.println( list.stream().filter(e->e.contains("A")).count());
    }
    public static void code2(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"Java","C++","Python","PHP");
        Stream<String> stream = list.stream();
        List<String> newList = stream.filter(e->e.contains("Java")).collect(Collectors.toList());
        System.out.println(newList);
    }
    public static void main(String[] args) {
      List<String>list = new ArrayList<>();
      Collections.addAll(list,"A","B","C","D");
      Stream<String> stream = list.stream();
      List<String>newList = stream.skip(1).limit(2).map(s->s.toLowerCase()).collect(Collectors.toList());
        System.out.println(newList);
    }

}
